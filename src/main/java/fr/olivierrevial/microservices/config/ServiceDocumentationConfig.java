package fr.olivierrevial.microservices.config;

import fr.olivierrevial.microservices.settings.ServiceDocumentationSettings;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;

/**
 * Springboot Service Documentation configuration.
 * This config enables all needed features by loading useful configs,
 * and also loads all cloud-related configs such as Discovery client, circuit breaker, etc.
 */
@Configuration
@ComponentScan(basePackages = { "fr.olivierrevial.microservices" })
@EnableConfigurationProperties({ ServiceDocumentationSettings.class})
public class ServiceDocumentationConfig {

    @Bean
    public Docket swaggerAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class,
                        String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(true);
    }
}

