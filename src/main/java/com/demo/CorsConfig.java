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
                                // AWS deployed frontend
                                "http://54.163.42.54",   // if served on default port 80
                                "http://54.163.42.54:6085", // if served on custom port
                                "https://your-domain.com"    // replace with your actual domain if using HTTPS
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
