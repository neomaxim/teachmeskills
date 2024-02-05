package auto.service;


import auto.model.Auto;

import java.util.List;


public interface AutoService {
    List<Auto> allCars();

    void add(Auto auto);


    void delete(Auto auto);

    void edit(Auto auto);

    Auto getById(int id);

    boolean checkVin(String vin);

    List<Auto> allCarsHttp();

}