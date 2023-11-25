package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationsByEtudiantListContains(Etudiant etudiant);
    List<Reservation> findReservationsByEtudiantListNomEtStartingWith(String prefix);

}
