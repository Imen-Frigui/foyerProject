package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capacityFoyer;
    private String region;
    private float lattitude ;
    private float longitude;
    @OneToOne(mappedBy = "foyer",cascade = CascadeType.ALL)
    private Universite universite;
    @OneToMany(mappedBy = "foyer",cascade = CascadeType.ALL)
    private List <Bloc> blocList;
    @OneToMany(cascade=CascadeType.ALL)
    private Set<Rate> ratingList;

}
