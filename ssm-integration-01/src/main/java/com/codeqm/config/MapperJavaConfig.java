package com.codeqm.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * @since: 2025/6/9 12:21
 * @author: qm
 * @description: 配置：持久层Mapper、数据库、Mybatis信息
 * 方式 1. 保留外部配置文件
 * * - 问题 1. 如果 dataSource 和 mybatis 的组件配置在一起，则 @value 注解会晚于 mybatis 组件加载，未读取到配置值就实例化了
 * *   - 分开配置，写到不同的类即可
 */
@Configuration
public class MapperJavaConfig {
    /*
     * 配置SqlSessionFactoryBean,指定连接池对象和外部配置文件即可
     *
     * @param dataSource 需要注入连接池对象
     * @return 工厂Bean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean(); // 实例化SqlSessionFactory工厂
        sqlSessionFactoryBean.setDataSource(dataSource);                           // 设置连接池
        Resource resource = new ClassPathResource("mybatis-config.xml");           // 设置配置文件
        sqlSessionFactoryBean.setConfigLocation(resource);                         // 包裹外部配置文件地址对象
        return sqlSessionFactoryBean;
    }

    /**
     * 配置Mapper实例扫描工厂,配置 <mapper><package/></mapper> 对应接口和mapperxml文件所在的包
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.codeqm.mapper"); // 设置mapper接口和xml文件所在的共同包
        return mapperScannerConfigurer;
    }
}
