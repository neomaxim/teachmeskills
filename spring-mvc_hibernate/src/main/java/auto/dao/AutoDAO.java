package auto.dao;


import auto.model.Auto;

import java.util.List;

public interface AutoDAO {
    List<Auto> allAutos(int page);
    void add(Auto auto);
    void delete(Auto auto);
    void edit(Auto auto);
    Auto getById(int id);

    int autosCount();

    boolean checkVin(String vin);
}
