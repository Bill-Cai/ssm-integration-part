package com.codeqm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @since: 2025/6/9 13:10
 * @author: qm
 * @description:
 */
public class SpringIocInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                DataSourceJavaConfig.class,
                MapperJavaConfigNew.class,
                ServiceJavaConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
