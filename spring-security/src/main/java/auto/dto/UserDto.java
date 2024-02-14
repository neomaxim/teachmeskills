package auto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDto extends CreateUserDto {


    @Override
    @JsonIgnore
    public String getPassword() {
        return super.getPassword();
    }
}