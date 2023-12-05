package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.*;
import tn.esprit.springproject.services.EtudiantServiceImp;
import tn.esprit.springproject.services.IEtudiant;
import tn.esprit.springproject.services.IReservation;
import tn.esprit.springproject.services.ReservationServiceImp;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@Tag(name = "reservation API")
public class ReservationController {
    public IReservation iReservation;
    public IEtudiant iEtudiant;

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation r) {
        return iReservation.addReservation(r);
    }

    @PutMapping("/edit")
    public Reservation updateReservation(@RequestBody Reservation r) {
        return iReservation.updateReservation(r);
    }

    @GetMapping("/get")
    public List<Reservation> findAllReservation() {
        return iReservation.getAllReservation();
    }

    @GetMapping("/get/{IdR}")
    public Reservation findReservationById(@PathVariable long IdR) {
        return iReservation.getReservationrById(IdR);
    }

    @DeleteMapping("/delete/{IdR}")
    public void deleteReservationById(@PathVariable long IdR) {
        iReservation.deleteReservation(IdR);
    }

    @GetMapping("/getReservationByetudiant/{id}")
    public List<Reservation> findReservationByEtudiant(@PathVariable long id) {
        Etudiant etudiant = iEtudiant.getById(id);
        return iReservation.findReservationsByEtudiantListContains(etudiant);

    }

    @GetMapping("/getReservationByEtudiantNom/{nom}")
    public List<Reservation> findReservationByEtudiantNom(@PathVariable String nom) {
        Etudiant etudiant = iEtudiant.findEtudiantByNom(nom);
        return iReservation.findReservationsByEtudiantListContains(etudiant);

    }

    @GetMapping("/getReservationByEtudiantAB")
    public List<Reservation> findReservationByEtudiantNom() {
        return iReservation.findReservationsByEtudiantNomContainsAB();
    }

    @GetMapping("/addReservationAndAssignToChambre/{idChambre}")
    public Reservation addReservationAndAssignToChambre(@RequestBody Reservation reservation, @PathVariable long idChambre) {
        return iReservation.addReservationAndAssignToChambre(reservation, idChambre);
    }

    @GetMapping("/findByReservation/{idReservation}")
    public Chamber findByReservation(@PathVariable long idReservation) {
        return iReservation.findByReservation(idReservation);
    }

    @PutMapping("/updateState/{stateReservation}")
    public Reservation updateState(@RequestBody Reservation reservation, @PathVariable StateReservation stateReservation) {
        return iReservation.updateState(reservation, stateReservation);
    }

    @GetMapping("findNumberEtudiantInCHambre/{idReservation}")
    public int findNumberEtudiantInCHambre(@PathVariable long idReservation) {
        return iReservation.findNumberEtudiantInCHambre(idReservation);
    }

}
