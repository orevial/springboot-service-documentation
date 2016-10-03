package fr.olivierrevial.microservices;

import java.net.UnknownHostException;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Springboot Service Documentation application.
 */
@EnableSwagger2
@SpringBootApplication
public class ServiceDocumentationApplication {
    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     * @throws BeansException if some beans failed to instantiate
     * @throws UnknownHostException if the local host name could not be resolved into an address
     */
    public static void main(String[] args) throws BeansException, UnknownHostException {
        SpringApplication.run(ServiceDocumentationApplication.class, args);
    }
}