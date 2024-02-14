package auto.mapper;

import auto.dto.AutoDto;
import auto.model.Auto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper()
public interface AutoMapper {
    AutoDto toAutoDto(Auto auto);

    Auto toAuto(AutoDto autodto);

    default List<AutoDto> toDtoList(List<Auto> auto) {
        return auto.stream().map(this::toAutoDto).toList();
    }

    default List<Auto> toAutoList(List<AutoDto> auto) {
        return auto.stream().map(this::toAuto).toList();
    }
}
