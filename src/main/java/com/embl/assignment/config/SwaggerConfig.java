package com.embl.assignment.config;

import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

import static springfox.documentation.builders.PathSelectors.*;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.embl.assignment.controllers"))
                .paths(regex("/date.*"))
                .build();
    }
}
