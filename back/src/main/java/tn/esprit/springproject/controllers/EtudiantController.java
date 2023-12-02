package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.User;
import tn.esprit.springproject.services.UserServiceImp;
import tn.esprit.springproject.services.IUser;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
@Tag(name = "etudiant API")
public class EtudiantController {
    public IUser iUser;
    public UserServiceImp etudiantServiceImp;


    @PostMapping("/addEt")
    public User addEtudiant(@RequestBody User e){
        return iUser.addUser(e);
    }

    @PutMapping("/editEt")
    public User updateUser(@RequestBody User e){
        return iUser.updateUser(e);
    }

    @GetMapping("/getEt")
    public List<User> findAllUsers(){
        return iUser.getAllUsers();
    }

    @GetMapping("/getEt/{IdE}")
    public User findUserById(@PathVariable long IdE){
        return  iUser.getById(IdE);
    }

    @DeleteMapping("/deleteEt/{IdE}")
    public void deleteUserById(@PathVariable long IdE){
        iUser.deleteUser(IdE);
    }

    @GetMapping("/etByValidReservation")
    public List<User> findByReservationList_EstValideTrue(){
        return  iUser.findByReservationList_EstValideTrue();
    }
    @GetMapping("/etByUniversity/{name}")
    public List<User> findAllByUniversity(@PathVariable String name){
        return iUser.findAllByUniversity(name);
    }
}
