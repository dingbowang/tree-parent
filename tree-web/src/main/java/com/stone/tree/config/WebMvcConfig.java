package com.stone.tree.config;

import com.stone.tree.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/stoneUser/register","/stoneUser/login");
    }

}
