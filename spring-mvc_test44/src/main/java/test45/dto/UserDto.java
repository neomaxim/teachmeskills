package test45.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import test45.entity.Role;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String userName;
    private String login;
    private String password;
    private Role role;
}
