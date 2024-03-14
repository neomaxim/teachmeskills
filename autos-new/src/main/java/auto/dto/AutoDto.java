package auto.dto;


import lombok.Builder;
import lombok.Data;




@Builder
@Data


public class AutoDto {


    private Long id;
    private String vin;
    private int year;
    private String brand;
    private boolean status;

    private String user;
    private int price;

    private byte[] avatar;
}
