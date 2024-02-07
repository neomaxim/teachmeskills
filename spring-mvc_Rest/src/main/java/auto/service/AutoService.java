package auto.service;



import auto.dto.AutoDto;
import auto.model.Auto;

import java.util.List;
import java.util.Optional;

public interface AutoService {
    List<Auto>  allCars();

 void add(Auto auto);
 // AutoDto add(AutoDto autoDto);


    void delete(Auto auto);

    void edit(Auto auto);

    Auto getById(int id);

}