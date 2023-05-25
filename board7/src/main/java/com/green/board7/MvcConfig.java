package com.green.board7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration  //스프링에 설정거는거
public class MvcConfig implements WebMvcConfigurer {
    @Value("${file.dir}")
    private String fileDir;

    @Override   //리소스 핸들링(조종) 하겠다
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory(fileDir, registry);
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);            //상대경로를 절대경로로 바꿔주는 소스, 상대경로는 상대경로로 표현
        String uploadPath = uploadDir.toFile().getAbsolutePath();   //
        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");    //여기까지.
        registry.addResourceHandler("images/**").addResourceLocations("file:/" + uploadPath + "/");
    }       //로케이션 경로로 이미지/**되는 것들을 매핑시키겠다 (뜻
}
