package test45.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto  {

 //   private Long id;
    private String userName;
    private String login;
    private String password;
    private String role;
}
