package auto.dto;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;


@Builder
@Data


public class AutoDto {
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String vin;
    private int year;
    private String brand;
    private boolean status;
    @NotNull
    @NotEmpty
    @NotBlank
    private String user;
    private byte[] avatar;
}
