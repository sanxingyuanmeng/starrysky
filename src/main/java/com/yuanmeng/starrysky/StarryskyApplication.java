package com.yuanmeng.starrysky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuanmeng.starrysky.mapper")
public class StarryskyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarryskyApplication.class, args);
    }

}
