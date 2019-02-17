package com.drc;

import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.drc.mybatis.mapper")
public class DrcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrcApplication.class, args);
    }

}

