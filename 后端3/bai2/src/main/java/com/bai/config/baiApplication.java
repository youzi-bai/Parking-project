package com.bai.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.bai.config.dao")
public class baiApplication {
    public static void main(String[] args) {
        SpringApplication.run(baiApplication.class, args);
    }
}
