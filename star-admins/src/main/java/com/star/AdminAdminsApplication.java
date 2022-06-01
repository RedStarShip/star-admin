package com.star;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.star.dao")
public class AdminAdminsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminAdminsApplication.class, args);
    }
}
