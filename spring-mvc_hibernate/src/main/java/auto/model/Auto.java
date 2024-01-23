package auto.model;

import javax.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vin")
    private String vin;

    @Column(name = "year")
    private int year;

    @Column(name = "brand")
    private String brand;

    @Column(name = "status")
    private boolean status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String brand) {
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

    public void setBrand(String genre) {
        this.brand = brand;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean watched) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " " + vin + " " + year + " " + brand + " " + status;
    }
}
