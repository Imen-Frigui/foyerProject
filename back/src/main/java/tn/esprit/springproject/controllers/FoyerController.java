package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.services.FoyerServiceImp;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@Tag(name = "foyer API")
public class FoyerController {
    @Autowired
    private FoyerServiceImp foyerServiceImp;
    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServiceImp.addFoyer(f);
    }
    @PutMapping("/edit")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return foyerServiceImp.updateFoyer(f);
    }
    @GetMapping("/get")
    public List<Foyer> findAllFoyer(){
        return foyerServiceImp.findAllFoyer();
    }
    @GetMapping("/get/{IdF}")
    public Foyer findFoyerById(@PathVariable long IdF){
        return  foyerServiceImp.findById(IdF);
    }
    @DeleteMapping("/delete/{IdF}")
    public void deleteFoyerById(@PathVariable long IdF){
        foyerServiceImp.deleteFoyer(IdF);
    }
    @GetMapping("/getbynom/{nomf}")
    public Foyer getByNom(@PathVariable String nomf){
        return foyerServiceImp.getByNomFoyer(nomf);
    }
}
