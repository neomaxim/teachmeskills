package auto.mapper;

import auto.dto.CreateUserDto;
import auto.dto.UserDto;
import auto.entity.User;
import auto.service.RoleService;
import org.mapstruct.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(source = "userName", target = "name")
    @Mapping(target = "role", ignore = true)
    UserDto toDto(User user);

    @Mapping(source = "name", target = "userName")
    @Mapping(target = "role", ignore = true)
    User toEntity(CreateUserDto user, @Context RoleService roleService, @Context PasswordEncoder passwordEncoder);

    @AfterMapping
    default void postConstruct(CreateUserDto userDto, @MappingTarget User user,
                               @Context RoleService roleService, @Context PasswordEncoder passwordEncoder) {
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        roleService.findByName(userDto.getRole()).ifPresent(user::setRole);

    }

    default List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }

    default List<User> toEntites(List<UserDto> users, @Context RoleService roleService, @Context PasswordEncoder passwordEncoder) {
        return users.stream().map(it -> toEntity(it, roleService, passwordEncoder)).toList();
    }
}