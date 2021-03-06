package com.smithwang.demoproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DemoProject1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoProject1Application.class, args);
    }

}
