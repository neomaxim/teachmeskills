package auto.mapper;

import auto.dto.AutoDto;
import auto.model.Auto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutoMapper {
    AutoDto toDTO(Auto model);

    Auto toModel(AutoDto dto);
}
