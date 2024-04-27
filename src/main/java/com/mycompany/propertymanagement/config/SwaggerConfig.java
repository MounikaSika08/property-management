package com.mycompany.propertymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Object appApi(){
       /* Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.mycompany.propertymanagement.controller"))
                .paths((PathSelectors.regex("/.*"))).build();
        return docket;*/
        return null;
    }
}
