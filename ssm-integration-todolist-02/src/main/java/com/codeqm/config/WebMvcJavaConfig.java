package com.codeqm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @since: 2025/6/9 12:05
 * @author: qm
 * @description:
 */
@Configuration
@ComponentScan(value = {
        "com.codeqm.controller",
})
@EnableWebMvc
public class WebMvcJavaConfig implements WebMvcConfigurer {
}
