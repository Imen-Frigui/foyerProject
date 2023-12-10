package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Universite implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    private String adresseUniversite;
    @JsonManagedReference
    @OneToOne
    private Foyer foyer;
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<UniversityEvent> universityEvents;
}
