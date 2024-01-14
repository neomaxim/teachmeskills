package temp41;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringBootRunner {
    public static void main(String[] args) {
        // SpringApplication.run(SpringBootRunner.class,args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootRunner.class,args);
        CalculatorService calculatorService = applicationContext.getBean(CalculatorService.class);
        // System.out.println();calculatorService.summa();
        log.info("summa 5 and 2 ={}",calculatorService.summa(5,2));
        log.info("minus 5 and 2 ={}",calculatorService.minus(5,2));
    }
}
