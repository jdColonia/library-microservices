package co.analisys.biblioteca.config;

import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(
            5000, // Connect timeout in milliseconds
            10000 // Read timeout in milliseconds
        );
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(
            1000, // Initial retry interval
            3000, // Max retry interval  
            3     // Max attempts
        );
    }
}
