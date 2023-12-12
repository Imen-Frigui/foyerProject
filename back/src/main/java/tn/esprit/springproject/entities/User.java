package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long idUser;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    @Enumerated(EnumType.STRING)
    private Role role;
    private long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @ManyToMany(mappedBy = "userList",cascade = CascadeType.ALL)
    @JsonBackReference
    private List <Reservation> reservationList;
}
