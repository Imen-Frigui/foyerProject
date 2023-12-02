package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.User;
import tn.esprit.springproject.entities.Reservation;
import tn.esprit.springproject.services.UserServiceImp;
import tn.esprit.springproject.services.ReservationServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@Tag(name = "reservation API")
public class ReservationController {
    public ReservationServiceImp reservationServiceImp;
    public UserServiceImp etudiantServiceImp;

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation r){ return reservationServiceImp.addReservation(r); }

    @PutMapping("/edit")
    public Reservation updateReservation(@RequestBody Reservation r){ return reservationServiceImp.updateReservation(r); }

    @GetMapping("/get")
    public List<Reservation> findAllReservation(){
        return reservationServiceImp.getAllReservation();
    }

    @GetMapping("/get/{IdR}")
    public Reservation findReservationById(@PathVariable long IdR){ return  reservationServiceImp.getReservationrById(IdR); }

    @DeleteMapping("/delete/{IdR}")
    public void deleteReservationById(@PathVariable long IdR){
        reservationServiceImp.deleteReservation(IdR);
    }
    @GetMapping("/getReservationByetudiant/{id}")
    public List<Reservation> findReservationBy(@PathVariable long id){
        User user = etudiantServiceImp.getById(id);
        return reservationServiceImp.findReservationsByEtudiantListContains(user);

    }
    @GetMapping("/getReservationByEtudiantNom/{nom}")
    public List<Reservation> findReservationByEtudiantNom(@PathVariable String nom){
        User user = etudiantServiceImp.findUserByNom(nom);
        return reservationServiceImp.findReservationsByEtudiantListContains(user);

    }
    @GetMapping("/getReservationByEtudiantAB")
    public List<Reservation> findReservationByEtudiantNom(){
        return reservationServiceImp.findReservationsByEtudiantNomContainsAB();
    }
}
