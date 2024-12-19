package com.enerjoy.config;

import com.enerjoy.interceptor.WebInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author xuzihao
 * @date 2024/12/17 13:46
 * @description: 表述层相关配置类
 */
@EnableWebMvc //装载RequestMappingHandlerMapping,RequestMappingHandlerAdaptor,json处理器
@Configuration
@ComponentScan({"com.enerjoy.controller",
                "com.enerjoy.exception",
                "com.enerjoy.interceptor"})
public class WebJavaConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/"); //配置拦截器
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views",".jsp"); //配置jsp访问前后缀
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); //配置资源映射
    }
}
