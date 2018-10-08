package ee.ut.cs.wad2018.tarbatu.liige;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "liikmed")

public class Liige {
    @Max(50)
    @NotNull
    private String eesnimi;

    @Max(40)
    @NotNull
    private String perenimi;


    private Date sünnipäev;
    private Integer telefon;

    @Id
    @Max(50)
    @NotNull
    private String e_post;

    @Max(30)
    @NotNull
    private String koosseis;

    @Max(30)
    @NotNull
    private String grupp;

    private char sugu;
}
