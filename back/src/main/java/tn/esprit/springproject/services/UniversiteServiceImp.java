package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversite{
    public UniversiteRepository universiteRepository;
    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public List<Universite> findAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findById(long idU) {
        return universiteRepository.findById(idU).orElse(null);
    }

    @Override
    public void deleteUniversite(long idU) {
        universiteRepository.deleteById(idU);
    }

    @Override
    public Universite getByNomUniversite(String nomU) {
        return null;
    }
}
