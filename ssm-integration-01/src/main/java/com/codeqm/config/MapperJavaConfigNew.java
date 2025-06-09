package com.codeqm.config;

import com.github.pagehelper.PageInterceptor;
import jakarta.enterprise.inject.spi.Interceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @since: 2025/6/9 12:21
 * @author: qm
 * @description: 配置：持久层Mapper、数据库、Mybatis信息
 * 方式 2. 不保留外部配置文件, 全部MyBatis配置都写在Java代码中
 */
@Configuration
public class MapperJavaConfigNew {
    /*
     * 配置SqlSessionFactoryBean,指定连接池对象和外部配置文件即可
     *
     * @param dataSource 需要注入连接池对象
     * @return 工厂Bean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        // settings
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        sqlSessionFactoryBean.setConfiguration(configuration);
        // typeAliases
        sqlSessionFactoryBean.setTypeAliasesPackage("com.codeqm.pojo");
        // plugins
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "postgresql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

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
