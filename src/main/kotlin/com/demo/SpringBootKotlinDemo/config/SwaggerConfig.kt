package com.demo.SpringBootKotlinDemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created by pooja on 15/5/18.
 */

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun productApi(): Docket {

        return Docket(DocumentationType.SWAGGER_2)

                .select().apis(RequestHandlerSelectors.any())

                .paths(regex("/api.*"))

                .build()
    }
}