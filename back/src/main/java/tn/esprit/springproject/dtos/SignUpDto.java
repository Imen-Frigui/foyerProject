package tn.esprit.springproject.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import tn.esprit.springproject.entities.Role;

import java.util.Date;

public record SignUpDto (String nom, String prenom, String email, long cin, String ecole, @Temporal(TemporalType.DATE) Date dateNaissance, @Enumerated(EnumType.STRING)
 Role role, char[] motDePasse) {

}
