package lesson39.service;


import lesson39.model.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> allAuto();
    void add(Auto auto);
    void delete(Auto auto);
    void edit(Auto auto);
    Auto getById(int id);
    void registration(String vin, String brand, Integer year);
}