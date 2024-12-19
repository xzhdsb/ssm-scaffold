package com.enerjoy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

/**
 * @author xuzihao
 * @date 2024/12/17 13:59
 * @description: 持久层配置类
 */
@Configuration
public class MapperJavaConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource druidDataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        //java配置
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        sqlSessionFactoryBean.setConfiguration(configuration);
        //typeAliases
        sqlSessionFactoryBean.setTypeAliasesPackage("com.enerjoy.entity");
        //分页插件配置
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.enerjoy.mapper");
        return configurer;
    }
}
