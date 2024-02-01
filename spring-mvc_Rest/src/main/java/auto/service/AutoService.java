package auto.service;


import auto.dto.AutoDto;
import auto.model.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> allAutos(int page);

    AutoDto create(AutoDto userDto);

    void add(Auto auto);

    void delete(Auto auto);

    void edit(Auto auto);

    Auto getById(int id);

    int autosCount();

    boolean checkVin(String vin);
}