package auto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;

@Builder
@Data



public class AutoDto {

   private Long id;
    private String vin;
    private int year;
    private String brand;
 private boolean status;


    @JsonIgnore
    private byte[] avatar;


}
