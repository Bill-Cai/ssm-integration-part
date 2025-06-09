package com.codeqm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @since: 2025/6/9 12:11
 * @author: qm
 * @description: 业务层配置类 service aop tx
 * 1. service
 * 2. 开启aop注解的支持aspect: @Before, @After, @Around, @AfterReturning, @AfterThrowing, @Aspect, @Order
 * 3. 开启事务注解的支持tx:
 * * (1) 对应的事务管理器实现
 * * (2) 开启事务注解的支持
 * * (3) 事务注解的使用 @Transactional
 * 4.
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(value={
        "com.codeqm.service",
        "com.codeqm.aspect"
})
public class ServiceJavaConfig {
    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
