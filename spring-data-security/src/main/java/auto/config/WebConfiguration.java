package auto.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {

    @Bean
    RestTemplate restTemplate() {
//        return new RestTemplate();
        return new RestTemplateBuilder().build();
    }



}