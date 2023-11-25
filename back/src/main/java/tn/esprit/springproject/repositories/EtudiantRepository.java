package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findEtudiantByNomEt(String nom);
    List<Etudiant> findEtudiantByNomEtStartingWith(String nom);
}
