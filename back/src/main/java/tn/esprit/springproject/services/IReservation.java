package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.User;
import tn.esprit.springproject.entities.Reservation;

import java.util.List;

public interface IReservation {
    public Reservation addReservation(Reservation R);
    public Reservation updateReservation(Reservation R);
    public List<Reservation> getAllReservation();
    public Reservation getReservationrById(long id);
    public void deleteReservation(long id);
    public List<Reservation> findReservationsByEtudiantListContains(User user);
    public List<Reservation> findReservationsByEtudiantNomContainsAB();


}
