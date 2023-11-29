package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.services.EtudiantServiceImp;
import tn.esprit.springproject.services.IEtudiant;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
@Tag(name = "etudiant API")
public class EtudiantController {
    public IEtudiant iEtudiant;
    public EtudiantServiceImp etudiantServiceImp;


    @PostMapping("/addEt")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return iEtudiant.addEtudiant(e);
    }

    @PutMapping("/editEt")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return iEtudiant.updateEtudiant(e);
    }

    @GetMapping("/getEt")
    public List<Etudiant> findAllEtudaint(){
        return iEtudiant.getAllEtudiants();
    }

    @GetMapping("/getEt/{IdE}")
    public Etudiant findEtudiantById(@PathVariable long IdE){
        return  iEtudiant.getById(IdE);
    }

    @DeleteMapping("/deleteEt/{IdE}")
    public void deleteEtudiantById(@PathVariable long IdE){
        iEtudiant.deleteEtudiant(IdE);
    }

    @GetMapping("/etByValidReservation")
    public List<Etudiant> findByReservationList_EstValideTrue(){
        return  iEtudiant.findByReservationList_EstValideTrue();
    }
    @GetMapping("/etByUniversity/{name}")
    public List<Etudiant> findAllByUniversity(@PathVariable String name){
        return iEtudiant.findAllByUniversity(name);
    }
}
