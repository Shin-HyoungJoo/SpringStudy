package com.green.board7.fileupload;

import com.green.board7.fileupload.model.FileEntity;
import com.green.board7.fileupload.model.FileLoadDto;
import com.green.board7.fileupload.model.FileuploadInsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fileupload")
public class FileuploadController {

    private final Logger LOGGER;
    private FileuploadService service;

    @Autowired
    public FileuploadController(FileuploadService service) {
        LOGGER = LoggerFactory.getLogger(FileuploadController.class);
        this.service = service;
    }

    //ResponseEntity는 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
    //HTTP 요청(Request) 또는 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스
    @GetMapping
    public ResponseEntity<Resource> download(FileLoadDto dto) {
        Resource file = service.fileLoad(dto);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,    //Content-Disposition http response body에 오는 컨텐츠 기질,성향을 알려주는 속성
                        //컨텐츠가 브라우저에 inline 되어야 하는 웹페이지 자체이거나
                        // 웹페이지의 일부인지, 아니면 attachment로써 다운로드 되거나
                        // 로컬에 저장될 용도록 쓰이는 것인지를 알려주는 헤더
                        "attachment; filename=\"" + file.getFilename() + "\"")  //attactment 붙이다 "\표현을 위해
                .body(file);    //원하는 값 바디에 담아 리턴
    }

    //파일 받을때
    //form data의 경우(MultipartFile img)만 적어도 된다
    //파일은 무조건 MultipartFile, consumes는 고정
    //img는 파일 주소값. 파일에 대한 객체정보가 담겨있다
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public void fileupload(@RequestPart FileuploadInsDto dto,
                           @RequestPart MultipartFile img) {
        LOGGER.info("dto : " + dto);
        LOGGER.info("imgFileName: " + img.getOriginalFilename());
        service.fileUpload(dto, img);
    }
}
