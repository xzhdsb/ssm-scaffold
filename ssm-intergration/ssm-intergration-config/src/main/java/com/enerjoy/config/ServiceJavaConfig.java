package com.enerjoy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xuzihao
 * @date 2024/12/17 13:57
 * @description: service，业务层配置类
 * 1.aop注解支持
 * 2.事务管理支持
 */
@Configuration
@EnableAspectJAutoProxy //开启注解支持
@EnableTransactionManagement //开启自动事务管理
@ComponentScan({"com.enerjoy.service"})
public class ServiceJavaConfig {

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }

}
