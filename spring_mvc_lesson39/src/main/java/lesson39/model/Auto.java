package lesson39.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Auto {
    private int id;
    @NotNull
    @NotEmpty
    private String vin;
    @NotNull
    @NotEmpty
    private String brand;
    private int year;

}
