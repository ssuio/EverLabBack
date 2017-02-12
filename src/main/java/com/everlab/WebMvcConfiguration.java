package com.everlab;

import javax.persistence.criteria.Order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry  registry) {
//    	registry.addResourceHandler("/index.html").addResourceLocations("file:views/");
    	registry.addResourceHandler("/**/*.map","/**/*.js","/**/*.css").addResourceLocations("file:webApp/views/");
    	registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
