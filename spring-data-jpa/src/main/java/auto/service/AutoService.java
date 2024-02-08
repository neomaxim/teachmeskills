package auto.service;



import auto.dto.AutoDto;


import java.util.List;

public interface AutoService {
    List<AutoDto>  allCars();

    AutoDto save(AutoDto autoDto);

    AutoDto getById(Long id);
    void delete(Long id);
}