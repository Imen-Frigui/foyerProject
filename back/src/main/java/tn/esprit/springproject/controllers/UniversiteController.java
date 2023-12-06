package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.services.FoyerServiceImp;
import tn.esprit.springproject.services.UniversiteServiceImp;

import java.util.List;

@RestController
@RequestMapping("/universite")
@Tag(name = "universite API")
@AllArgsConstructor
public class UniversiteController {

    public UniversiteServiceImp universiteServiceImp;
    public FoyerServiceImp foyerServiceImp;
    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServiceImp.addUniversite(u);
    }
    @PutMapping("/edit")
    public Universite updateUniversite(@RequestBody Universite u){
        return universiteServiceImp.updateUniversite(u);
    }
    @GetMapping("/get")
    public List<Universite> findAllUniversite(){
        return universiteServiceImp.findAllUniversite();
    }
    @GetMapping("/get/{IdU}")
    public Universite findUniversiteById(@PathVariable long IdU){
        Universite universite = universiteServiceImp.findById(IdU);
        Foyer foyer = foyerServiceImp.findById(universite.getFoyer().getIdFoyer());
        universite.setFoyer(foyer);
        return  universite;
    }
    @DeleteMapping("/delete/{IdU}")
    public void deleteUniversiteById(@PathVariable long IdU){
        universiteServiceImp.deleteUniversite(IdU);
    }

    @PostMapping("/addUniversityAndAssignToFoyer/{foyerId}")
    public Universite addUniversityAndAssignToFoyer(@RequestBody Universite universite, @PathVariable long foyerId) {
        Foyer foyer = foyerServiceImp.findById(foyerId);
        return universiteServiceImp.addUniversityAndAssignToFoyer(universite, foyer);
    }


    @GetMapping("/not-assigned")
    public List<Foyer> getFoyersNotAssignedToUniversity() {
        return universiteServiceImp.findFoyersNotAssignedToUniversity();
    }
}
