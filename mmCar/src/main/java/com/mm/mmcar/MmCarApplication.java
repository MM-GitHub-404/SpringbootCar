package com.mm.mmcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.mm.mmcar.listener", "com.mm.mmcar.filter"})
@EnableTransactionManagement
public class MmCarApplication {
    public static void main(String[] args) {
        SpringApplication.run(MmCarApplication.class, args);
    }

}