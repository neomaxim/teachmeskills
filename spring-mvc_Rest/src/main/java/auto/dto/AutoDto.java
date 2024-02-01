package auto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class AutoDto {
    private Long id;

    @JsonIgnore
    private byte[] avatar;
}
