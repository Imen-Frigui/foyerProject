package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomET;
    private long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean estValide;
    @ManyToMany(mappedBy = "etudiantList")
    @JsonBackReference
    private List <Reservation> reservationList;
}
