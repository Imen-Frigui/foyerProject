package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chamber;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chamber,Long> {
    List<Chamber> findChambersByBloc(Bloc B);


//
//@Query("select c from Chamber c where c.idChambre not in (select r.chamber.idChambre from Reservation r where r.anneUniversitaire = ?1)")
//    List<Chamber> getAvailableChambers();
}
