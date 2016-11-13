package fr.olivierrevial.microservices;

import fr.olivierrevial.microservices.settings.ServiceDocumentationSettings;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import java.net.UnknownHostException;

/**
 * Springboot Service Documentation application.
 */
@SpringBootApplication
@ComponentScan(basePackages = { "fr.olivierrevial.microservices" })
@EnableConfigurationProperties({ ServiceDocumentationSettings.class})
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