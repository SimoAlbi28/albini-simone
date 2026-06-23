package com.portale.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                // origini permesse: "*" = tutte (per sviluppo)
                .allowedOriginPatterns("*")
                // metodi HTTP permessi
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // tutti gli header (es. Content-Type) sono permessi
                .allowedHeaders("*")
                // niente cookie/credenziali sulle richieste (non mi servono)
                .allowCredentials(false);
    }
}
