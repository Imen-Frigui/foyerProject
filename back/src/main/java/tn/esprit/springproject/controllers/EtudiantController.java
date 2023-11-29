package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.services.EtudiantServiceImp;
import tn.esprit.springproject.services.IEtudiant;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
@Tag(name = "etudiant API")
public class EtudiantController {
    public IEtudiant iEtudiant;

    @PostMapping("/addEd")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return iEtudiant.addEtudiant(e);
    }

    @PutMapping("/editEd")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return iEtudiant.updateEtudiant(e);
    }

    @GetMapping("/getEd")
    public List<Etudiant> findAllEtudaint(){
        return iEtudiant.getAllEtudiants();
    }

    @GetMapping("/getEd/{IdE}")
    public Etudiant findEtudiantById(@PathVariable long IdE){
        return  iEtudiant.getById(IdE);
    }

    @DeleteMapping("/delete/{IdE}")
    public void deleteEtudiantById(@PathVariable long IdE){
        iEtudiant.deleteEtudiant(IdE);
    }
}
