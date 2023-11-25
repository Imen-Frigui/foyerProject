package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chamber;
import tn.esprit.springproject.entities.TypeChambre;

import java.util.List;
import java.util.Set;

public interface BolcRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findByChamberListTypeC(TypeChambre type);

}
