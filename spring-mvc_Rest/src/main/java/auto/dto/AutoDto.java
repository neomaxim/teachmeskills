package auto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AutoDto {

   private Long id;

    @JsonIgnore
    private byte[] avatar;
}
