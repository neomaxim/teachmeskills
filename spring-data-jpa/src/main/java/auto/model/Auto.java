package auto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autos")
@NamedEntityGraph(name="Auto.roles",attributeNodes = @NamedAttributeNode("roles"))
public class Auto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vin")
    private String vin;


    @Column(name = "year")
    private int year;

    @Column(name = "brand")
    private String brand;

    @Column(name = "status")
    private boolean status;


    @Column(name = "user")
    private String user;
@Column(name="avatar")
    @JsonIgnore
    private byte[] avatar;



@OneToMany
private List<Role> roles;

 /*   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   *//* @Override
    public String toString() {
        return id + " " + vin + " " + year + " " + brand + " " + status;
    }*//*

    @Override
    public String toString() {
        return id + " " + vin + " " + year + " " + brand + " " + status+" "+ avatar;
    }*/
}
