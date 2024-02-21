package mx.edu.utez.captcha8a.captchaservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    // Nuestro componente que nos sirve para hacer envío
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
