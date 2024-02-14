package auto.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.transaction.Status;
import java.util.List;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "users")
@NamedEntityGraph(name = "User.role", attributeNodes = @NamedAttributeNode("role"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String login;

    private String password;

//    private String oldName;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}