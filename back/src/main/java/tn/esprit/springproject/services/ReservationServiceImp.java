package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Chamber;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Reservation;
import tn.esprit.springproject.entities.StateReservation;
import tn.esprit.springproject.repositories.ChambreRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;
import tn.esprit.springproject.repositories.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImp implements IReservation{

    public ReservationRepository reservationRepository;
    public EtudiantRepository etudiantRepository;
    public ChambreRepository chambreRepository;

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
        return reservationRepository.findAll(Sort.by(Sort.Order.desc("idReservation")));
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

    @Override
    public Reservation addReservationAndAssignToChambre(Reservation reservation, long idChambre) {
        reservationRepository.save(reservation);
        Chamber chamber = findByReservation(reservation.getIdReservation());
        List<Reservation> list = chamber.getReservationList();
        if (list.isEmpty()) {
            list.add(reservation);
        }
        chamber.setReservationList(list);
        chambreRepository.save(chamber);
        return reservation;
    }

    @Override
    public Chamber findByReservation(long idReservation) {
        return chambreRepository.findByReservationList(reservationRepository.findById(idReservation).get());
    }

    @Override
    public Reservation updateState(Reservation reservation, StateReservation stateReservation) {
        reservation.setState(stateReservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public int findNumberEtudiantInCHambre(long idReservation) {
        List<Reservation> list = findByReservation(idReservation).getReservationList();
        int number = 0;
        for (Reservation reservation1: list) {
            if (reservation1.getState().equals(StateReservation.CONFIRMED)) {
                number = number + reservation1.getEtudiantList().size();
            }
        }
        return number;
    }
}
