package com.iocruz.bookscode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * MvcConfiguration
 */
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Bean
    public InternalResourceViewResolver internalResourceView() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setExposedContextBeanNames("carrinho");
        return resolver;
    }
    
}