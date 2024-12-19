package com.enerjoy.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author xuzihao
 * @date 2024/12/17 13:56
 * @description: 配置类初始化类
 */
public class JavaConfigInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ServiceJavaConfig.class, MapperJavaConfig.class, DataSourceJavaConfig.class}; //定义业务层、持久层配置文件
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebJavaConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
