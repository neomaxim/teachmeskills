package lesson37.config;

import lesson37.dao.CarDao;
import lesson37.dao.impl.CarUsaDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("lesson37")

public class AppConfig {
    @Bean
    @Primary
    CarDao carUsaDao() {
        return new CarUsaDao();
    }
}
