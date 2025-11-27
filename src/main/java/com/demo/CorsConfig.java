package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins(
                                // Local development
                                "http://localhost:6085",
                                "http://localhost:5173",
                                "http://localhost:8080",
                                "http://localhost:80",
                                "http://localhost:30081",
                                "http://localhost:30080",
                            
                            
                            
                                "http://98.91.0.193:6085",
                                // New IP added
                                "https://98.91.0.193",
                                // Your actual domain
                                "https://your-domain.com"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}

