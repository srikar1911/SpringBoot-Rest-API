package com.BootRestProj07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerDocConfiguration {

    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.BootRestProj07.rest"))
                .paths(PathSelectors.regex("/doctor.*"))
                .build()
                .useDefaultResponseMessages(true)
                .apiInfo(getAPIInfo());
    }
    private ApiInfo getAPIInfo(){
        Contact contact = new Contact("java", "https://www.java.com/en/", "srisc1911@gmail.com");
        return new ApiInfo("Doctor API", "info about doctors","1.0","https://www.java.com/en/",contact,"openSource","https://www.java.com/en/", Collections.emptyList());
    }


}
