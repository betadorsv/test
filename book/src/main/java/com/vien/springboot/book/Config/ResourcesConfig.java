package com.vien.springboot.book.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/FileUpload/**")
                .addResourceLocations("file:src/main/webapp/FileUpload/image")
                .addResourceLocations("file:src/main/webapp/FileUpload/content");
    }
}
