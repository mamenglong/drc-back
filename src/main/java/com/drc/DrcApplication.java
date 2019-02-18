package com.drc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@SpringBootApplication
@MapperScan("com.drc.mybatis.mapper")
public class DrcApplication {
    @Value("${web.temp-path}")
private String tempPath;
    public static void main(String[] args) {
        SpringApplication.run(DrcApplication.class, args);
    }
    /**
     * 文件上传临时路径
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        File file=new File(tempPath);
        if(!file.exists()){
            file.mkdirs();
        }
        factory.setLocation(tempPath);
        return factory.createMultipartConfig();
    }
}

