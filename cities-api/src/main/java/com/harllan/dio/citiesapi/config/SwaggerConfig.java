package com.harllan.dio.citiesapi.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String BASE_PACKAGE = "com.harllan.dio.citiesapi";
    private static final String API_TITLE = "Cities API";
    private static final String API_DESCRIPTION = "REST API to search cities, states, countries and calculate distances between cities.";
    private static final String CONTACT_NAME = "Harllan Andryê";
    private static final String CONTACT_GITHUB = "https://gtihub.com/harllanandrye";
    private static final String CONTACT_EMAIL = "...@mail.com";
    
    public static final String TAG_CITY = "City";
    public static final String TAG_STATE = "State";
    public static final String TAG_COUNTRY = "Country";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .tags(
                	new Tag(TAG_CITY, "Endpoints for cities."),
                	new Tag(TAG_STATE, "Endpoints for states."),
                	new Tag(TAG_COUNTRY, "Endpoints for countries.")
                )
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version("0.0.1-SNAPSHOT")
                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }

}
