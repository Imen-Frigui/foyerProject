package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.EtudiantRepository;

import java.util.List;

@Service("EtudiantServiceImp")
@AllArgsConstructor
public class EtudiantServiceImp implements IEtudiant{

    private EtudiantRepository etudiantRepository;
    @Override
    public Etudiant addEtudiant(Etudiant E) {
        return etudiantRepository.save(E);
    }

    @Override
    public Etudiant updateEtudaint(Etudiant E) {
        return etudiantRepository.save(E);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getById(long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEtudiant(long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant findEtudiantByNom(String nom) {
        return etudiantRepository.findEtudiantByNomEt(nom);
    }

    @Override
    public List<Etudiant> findetudiantsStartsWith() {
        String nom = "AB";
        return etudiantRepository.findEtudiantByNomEtStartingWith(nom);
    }
}
