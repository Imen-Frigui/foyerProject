package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Rate;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Long> {
    @Query("select r from Rate r join Foyer f where f.idFoyer = :idfoyer")
    List<Rate> findByFoyer(long idfoyer);

}
