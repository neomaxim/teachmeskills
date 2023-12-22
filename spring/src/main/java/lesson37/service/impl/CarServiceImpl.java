package lesson37.service.impl;

import lesson37.dao.CarDao;
import lesson37.model.Car;
import lesson37.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    @Override
    public void manufacturingIndividual() {
        Car car = new Car(123, "BMW", 2022);
        carDao.save(car);
    }

    @Override
    public void manufacturing() {
        List<Car> cars = List.of(new Car(964, "Reno", 2022),
                new Car(568, "Volvo", 2022),
                new Car(854, "Lada", 2023));
        cars.forEach(carDao::save);
    }
}
