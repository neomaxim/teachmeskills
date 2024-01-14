package lesson41.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson41.dto.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
//@EnableAutoConfiguration(exclude = WebSer.class)
public class SpringBootRunner {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootRunner.class, args);
        CalculatorService calculatorService = applicationContext.getBean(CalculatorService.class);
        log.info("Summa 5 and 2 = {}", calculatorService.summa(5, 2));
        log.info("Minus 5 and 2 = {}", calculatorService.minus(5, 2));
//        log.info("String bean {}", applicationContext.getBean(String.class));

        ObjectMapper objectMapper = applicationContext.getBean(ObjectMapper.class);
        log.info("Car as json: {}", objectMapper.writeValueAsString(new Car(1L, "Octavia", "Skoda")));

      //  AppProperties appProperties = applicationContext.getBean(AppProperties.class);
       // log.info("app.setting.age = {}", appProperties.getSetting().getAge());
       // log.info("app.setting.name = {}", appProperties.getSetting().getName());

        TestService testService = applicationContext.getBean(TestService.class);

//        log.info("app.setting.age = {}", new SpringBootRunner().age);
    }

    @Value("${app.setting.age}")
    private Long age;

//    @Bean
//    public String hello() {
//        return "Hello world";
//    }

}
