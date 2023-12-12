package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Universite;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    public Foyer findByNomFoyer(String nomFoyer);

    public Foyer findByUniversite(Universite universite);

}
