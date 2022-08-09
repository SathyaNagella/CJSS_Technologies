package com.example.springvalidator.Interseptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class InterseptorClassWebConfig implements WebMvcConfigurer {
    @Autowired
    InterseptorClass interseptorClass;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interseptorClass);
    }


}
