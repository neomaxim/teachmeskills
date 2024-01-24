package test44.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {

    @Min(1)
    @Max(100)
//    @Range(min = 1, max = 100)
    private Integer age;

    @NotNull
    @NotEmpty
    @Size(max = 100, min = 4)
    private String login;

    //    @Pattern(regexp = "^\\d+")
    @NotNull
    @NotEmpty
    private String password;

    @Email
    private String email;

//    @AssertTrue
//    private boolean agreed;
}