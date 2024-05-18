package com.hybrid.hybridhavenapi.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webconfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500", "http://34.251.172.36:8080", "http://34.251.172.36:5500", "https://hybrid-haven.projects.bbdgrad.com") // Allow requests from any origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow only specific methods
                .allowCredentials(true)
                .allowedHeaders("*");
    }
}
