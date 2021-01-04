package com.stone.tree;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author dbw
 * @date 2021/01/03/8:26 下午
 * @Description
 */
public class WarStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //  指向Application 这个启动类
        return builder.sources(TreeWebApplication.class);
    }


}
