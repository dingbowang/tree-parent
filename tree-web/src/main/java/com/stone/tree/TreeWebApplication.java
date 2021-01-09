package com.stone.tree;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@MapperScan(basePackages={"com.stone.tree.web.*.mapper"})
@EnableSwagger2
@SpringBootApplication
public class TreeWebApplication{

    public static void main(String[] args) {
        SpringApplication.run(TreeWebApplication.class, args);
    }
}
