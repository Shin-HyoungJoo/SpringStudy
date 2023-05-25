package com.green.board7.fileupload;

import com.green.board7.fileupload.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

@Service
public class FileuploadService {
    private FileuploadMapper mapper;

    @Value("${file.dir}")   //경로 주소가 들어간다
    private String fileDir; //경로 주소가 들어간다

    @Autowired
    public FileuploadService(FileuploadMapper mapper) {
        this.mapper = mapper;
    }

    public Resource fileLoad(FileLoadDto dto) {
        FileEntity entity = mapper.selFileById(dto);
        try {
            File file = new File(fileDir + entity.getPath());
            Resource resource = new UrlResource(file.toURI());
            if (resource.exists()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();    //실제로 로그남겨야 한다.
        }
        return null;
    }

    public void fileUpload(FileuploadInsDto dto, MultipartFile img) {
        System.out.println("fileDir : " + fileDir);

        //원래 파일 이름 추출
        String originFileName = img.getOriginalFilename();

        //파일 이름으로 사용할 uuid생성
        String uuid = UUID.randomUUID().toString();

        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedFileName = uuid + ext;  //경로구분 가능할때
        String savedFilePath = fileDir + savedFileName; //경로구분 안해도될때

        File file = new File(savedFilePath);

        try {   //파일을 경로에 넣는다? //파일이 있냐 묻는다?
            img.transferTo(file);

            FileEntity entity = FileEntity.builder()    //빌더는 생성자 노가다를 하지않고 멤버필드를 골라서 값을 넣기 위해서 쓴다
                    .path(savedFileName)
                    .uploader(dto.getUploader())
                    .levelValue(dto.getLevelValue())
                    .build();
            mapper.insFile(entity);

        } catch (IOException e) {   //없으면 뿌려라
            e.printStackTrace();
        }
    }
}
