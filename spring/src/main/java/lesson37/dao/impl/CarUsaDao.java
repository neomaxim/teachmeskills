package lesson37.dao.impl;

import lesson37.dao.CarDao;
import lesson37.model.Car;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class CarUsaDao implements CarDao {
    @Override
    public void save(Car car) {
        log.info("Try to save car" + car);
    }
}
