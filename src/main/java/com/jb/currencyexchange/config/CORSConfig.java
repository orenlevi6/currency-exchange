package com.jb.currencyexchange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CORSConfig {
    @Bean
    public CorsFilter corsFilter() {
        //Create new URL configuration for browsers
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //Create new CORS configuration....
        CorsConfiguration config = new CorsConfiguration();
        //Allow to get credentials in CORS
        config.setAllowCredentials(true);
        //Allow to get from any IP / Domain
        config.addAllowedOriginPattern("*");
        //Allow to get any header
        config.addAllowedHeader("*");
        //Allow to get methods
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        //Tell spring expose authorization header
        config.setExposedHeaders(List.of("authorization"));
        //Allow to get any route -> localhost:8080/api/lecturer -> /api/lecture is route
        source.registerCorsConfiguration("/**", config);

        ///Return new configuration
        return new CorsFilter(source);
    }

}
