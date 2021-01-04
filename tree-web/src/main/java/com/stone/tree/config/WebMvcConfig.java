package com.stone.tree.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author dbw
 * @date 2021/01/03/7:39 下午
 * @Description
 *
 * 在SpringBoot2.0及Spring 5.0 WebMvcConfigurerAdapter已被废弃，目前找到解决方案就有
 * 1 直接实现WebMvcConfigurer （官方推荐）
 * 2 直接继承WebMvcConfigurationSupport
 * @ https://blog.csdn.net/lenkvin/article/details/79482205
 */
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

}
