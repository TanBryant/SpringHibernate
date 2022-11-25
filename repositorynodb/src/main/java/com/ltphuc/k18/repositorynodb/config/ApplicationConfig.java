package com.ltphuc.k18.repositorynodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ltphuc.k18.repositorynodb.repository.ProductRepository;
import com.ltphuc.k18.repositorynodb.repository.ProductRepositoryImpl;
import com.ltphuc.k18.repositorynodb.service.ProductService;
import com.ltphuc.k18.repositorynodb.service.ProductServiceImpl;



@Configuration
@EnableWebMvc
@ComponentScan("com.ltphuc.k18.repositorynodb")

public class ApplicationConfig implements WebMvcConfigurer{
	@Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }
}
