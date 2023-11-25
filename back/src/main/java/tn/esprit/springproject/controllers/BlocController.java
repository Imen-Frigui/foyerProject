package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chamber;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.TypeChambre;
import tn.esprit.springproject.services.BlocSericeImp;
import tn.esprit.springproject.services.EtudiantServiceImp;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
@Tag(name="bloc API")
public class BlocController {

    public BlocSericeImp blocSericeImp;
    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc b){
        return blocSericeImp.addBloc(b);
    }
    @PutMapping("/edit")
    public Bloc updateBloc(@RequestBody Bloc b){
        return blocSericeImp.updateBloc(b);
    }
    @GetMapping("/get")
    public List<Bloc> findAllBloc(){
        return blocSericeImp.getAllBloc();
    }
    @GetMapping("/get/{IdB}")
    public Bloc findBlocById(@PathVariable long IdB){
        return blocSericeImp.getById(IdB);
    }
    @DeleteMapping("/delete/{IdB}")
    public void deleteFoyerById(@PathVariable long IdB){
        blocSericeImp.deleteBloc(IdB);
    }
    @GetMapping("/getBlocByTypeC/{type}")
    public List<Bloc> findBlocByTypeC(@PathVariable TypeChambre type){
        return blocSericeImp.findByChamberListTypeC(type);
    }
    @GetMapping("/getBlocByChambre/{chambreId}")
    public Bloc getBlocByChambre(@PathVariable long chambreId){
        return blocSericeImp.getBlocByChambreId(chambreId);
    }

}
