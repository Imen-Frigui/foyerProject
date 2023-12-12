package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Universite implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    private String adresseUniversite;
    @OneToOne
    @JsonIgnore
    private Foyer foyer;
}
