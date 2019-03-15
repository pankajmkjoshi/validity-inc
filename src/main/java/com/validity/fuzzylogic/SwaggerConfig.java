package com.validity.fuzzylogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger end points listing.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public Docket restAPI() {
        LOGGER.debug("initializing Swagger Docket...");
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.validity.fuzzylogic.controller"))
                .build().apiInfo(apiInfo());
    }

    /**
     * API Info as it appears on the swagger-ui page
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Validity Community").description("Validity – Trust your data. Any time. Every time.")
                .version("1.0").build();
    }
}
