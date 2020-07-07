package com.examination;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.examination")
@MapperScan("com.examination.dao")
public class ExaminationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExaminationApplication.class, args);
    }

}
