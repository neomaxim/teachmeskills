package hw42.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
