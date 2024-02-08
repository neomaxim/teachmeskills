package auto.mapper;

import auto.dto.AutoDto;
import auto.model.Auto;
import org.mapstruct.Mapper;

@Mapper()
public interface AutoMapper {
    AutoDto toAutoDto(Auto auto);

    Auto toAuto(AutoDto autodto);
}
