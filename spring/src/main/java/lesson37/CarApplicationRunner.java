package lesson37;

import lesson37.config.AppConfig;
import lesson37.dao.CarDao;
import lesson37.service.CarService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j
public class CarApplicationRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CarDao carDao = context.getBean("carChinaDao", CarDao.class);
        CarDao carDao2 = context.getBean("carUsaDao", CarDao.class);
        CarService carService = context.getBean(CarService.class);
        log.info("dao - {}" + carDao);
        log.info("dao - {}" + carDao2);
        log.info("service - {}" + carService);
        carService.manufacturingIndividual();
        carService.manufacturing();
    }
}
