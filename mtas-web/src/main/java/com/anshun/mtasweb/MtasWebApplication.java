package com.anshun.mtasweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mtasflash Created on 2022-04-29 15:15
 */
@SpringBootApplication
@MapperScan("com.anshun.mtasweb.dao")
public class MtasWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MtasWebApplication.class, args);
    }

}
