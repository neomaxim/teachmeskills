package auto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;


@Entity
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autos")
public class Auto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "vin")
    // @Size(max = 12, min = 12)
    private String vin;


    @Column(name = "year")

    private int year;

    @Column(name = "brand")
    private String brand;

    @Column(name = "status")
    private boolean status;


    @Column(name = "user")
    private String user;

    // @Column(name = "price")
    //  private int price;

    @Column(name = "avatar")
    @JsonIgnore
    private byte[] avatar;


}
