package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chamber;
import tn.esprit.springproject.entities.Reservation;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chamber,Long> {
    List<Chamber> findChambersByBloc(Bloc B);

    @Query("select c from Chamber c where :r in elements(c.reservationList) ")
    Chamber findByReservationList(@Param("r") Reservation r);
}
