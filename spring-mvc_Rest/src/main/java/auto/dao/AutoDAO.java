package auto.dao;


import auto.model.Auto;

import java.util.List;
import java.util.Optional;

public interface AutoDAO {

   // Optional<Auto> getCarById(Long id);

    Auto  saveAuto(Auto auto);
  void add(Auto auto);



    List<Auto> getAllAuto();
    void delete(Auto auto);
    Auto getById(int id);

    void edit(Auto auto);
}
