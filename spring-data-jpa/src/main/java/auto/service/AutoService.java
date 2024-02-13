package auto.service;



import auto.dto.AutoDto;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface AutoService {
    List<AutoDto>  allCars();

    List<AutoDto> getAll(Pageable pageable);

 List<AutoDto> findByVin(String vin);

    AutoDto save(AutoDto autoDto);

    AutoDto getById(Long id);
    void delete(Long id);


}