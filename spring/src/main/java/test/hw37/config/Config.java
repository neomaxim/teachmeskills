package test.hw37.config;

import org.springframework.context.annotation.*;
import test.hw37.dao.ReportDao;
import test.hw37.dao.impl.ReportJpaDao;


@Configuration
@ComponentScan("test.hw37")
@PropertySource(
        {"classpath:resources.properties",
                "classpath:app.properties" }
        )

public class Config {
    @Bean
    @Primary
    //@Qualifier("reportJpaDao")
    ReportDao reportJpaDao(){
        return  new ReportJpaDao();
    }
    @Bean
    String helloWorld(){
        return "Hello world";
    }
}
