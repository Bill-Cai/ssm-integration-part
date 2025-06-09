package com.codeqm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @since: 2025/6/9 12:05
 * @author: qm
 * @description: 控制层的配置类(controller, springmvc)
 * 1. controller
 * 2. 全局异常处理器
 * 3. handlerMapping handlerAdapter
 * 4. 静态资源处理器
 * 5. 视图解析器 jsp 前后缀
 * 6. json转换器
 * 7. 拦截器
 * ...
 */
@Configuration
@ComponentScan(value = {
        "com.codeqm.controller",
})
@EnableWebMvc
public class WebMvcJavaConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); // 配置默认的servlet处理器, 使得静态资源可以被访问
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp"); // 配置视图解析器, 指定前缀和后缀
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new HandlerInterceptor() {
//        });
//    }
}
