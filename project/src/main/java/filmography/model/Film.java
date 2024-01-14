package filmography.model;

import lombok.Data;

@Data
public class Film {
    private int id;
    private String title;
    private int year;
    private String genre;
    private boolean watched;

}
