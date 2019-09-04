package com.tucker.gmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.tucker.gmall.userservice.mapper")
public class GmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.tucker.gmall.user.GmallUserApplication.class, args);
    }

}
