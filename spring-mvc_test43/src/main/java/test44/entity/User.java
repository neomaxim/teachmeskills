package test44.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import test44.dto.UserDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class User {
  @Id
    private Long id;
    private String userName;
    private String login;
    private String password;
    private String role;  //User,admin,guest

    private LocalDateTime createdAt;
    private boolean deletable;
    public User(UserDto userDto){
      this.userName = userDto.getUserName();
      this.userName=userDto.getLogin();
      this.password=userDto.getPassword();
      this.role=userDto.getRole();
    }


}
