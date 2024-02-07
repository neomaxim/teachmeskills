package auto.service;

import auto.dao.AutoDAO;
import auto.dto.AutoDto;
import auto.mapper.AutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AvatarService {
    private final AutoMapper autoMapper;
    private final AutoDAO autoDAO;

  /*  public AutoDto getCarById(Long id) {
        return autoMapper.toDTO(autoDAO.getCarById(id).get());


    }*/

  /*  public AutoDto add(AutoDto autoDto) {
        return autoMapper.toDTO(autoDAO.saveAuto(autoMapper.toModel(autoDto)));
    }*/
}
