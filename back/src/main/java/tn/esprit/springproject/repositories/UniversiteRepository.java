package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    public List <Universite> findByNomUniversiteContainingIgnoreCase(String nom);
    public List <Universite> findByAdresseUniversiteContainingIgnoreCase(String address);
    public List <Universite> findByFoyer_IdFoyer(long id);
}
