package ee.ut.cs.wad2018.tarbatu.user;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @NotNull
    @Size(max = 50)
    private String username;

    @Size(max = 50)
    private String code;

    public User() {}

    public User(String username){
        this.username = username;
    }
    public User(String username, String code){
        this.username = username; this.code = code;
    }
}