package auto.dao;


import auto.model.Auto;

import java.util.List;

public interface AutoDAO {
    List<Auto> getAllAuto();

  void add(Auto auto);
    void delete(Auto auto);
    Auto getById(int id);

    void edit(Auto auto);

    boolean checkVin(String vin);
}
