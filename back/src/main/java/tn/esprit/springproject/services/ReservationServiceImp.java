package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Reservation;
import tn.esprit.springproject.repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImp implements IReservation{

    public ReservationRepository reservationRepository;
    @Override
    public Reservation addReservation(Reservation R) {
        return reservationRepository.save(R);
    }

    @Override
    public Reservation updateReservation(Reservation R) {
        return reservationRepository.save(R);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationrById(long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findReservationsByEtudiantListContains(Etudiant etudiant) {
        return reservationRepository.findReservationsByEtudiantListContains(etudiant);
    }

    @Override
    public List<Reservation> findReservationsByEtudiantNomContainsAB() {
        return reservationRepository.findReservationsByEtudiantListNomEtStartingWith("AB");
    }

}
