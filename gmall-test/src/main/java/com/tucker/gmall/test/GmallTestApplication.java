package com.tucker.gmall.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GmallTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallTestApplication.class, args);
    }

}
