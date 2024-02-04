package test45.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import test45.dto.UserDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @EmbeddedId
//    private UserId userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "login", unique = true)
    private String login; //should be unique
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true, mappedBy = "user")//(fetch = FetchType.EAGER)
    private List<Phone> phones = new ArrayList<>();

    //    @CreationTimestamp
    @UpdateTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private boolean deletable = false;

    public User(UserDto userDto) {
        this.userName = userDto.getUserName();
        this.login = userDto.getLogin();
        this.password = userDto.getPassword();
        this.role = userDto.getRole();
    }

    public User update(UserDto userDto) {
        this.setUserName(userDto.getUserName());
        this.setLogin(userDto.getLogin());
        this.setPassword(userDto.getPassword());
        this.setRole(userDto.getRole());
        return this;
    }
}
