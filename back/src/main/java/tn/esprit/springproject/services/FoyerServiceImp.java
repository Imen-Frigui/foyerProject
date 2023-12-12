package tn.esprit.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.repositories.FoyerRepository;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerServiceImp implements IFoyer{

    @Autowired
    private FoyerRepository foyerRepository;
    @Autowired
    private UniversiteRepository universiteRepository;
    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> findAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(long idF) {
        return foyerRepository.findById(idF).orElse(null);
    }

    @Override
    public void deleteFoyer(long idF) {
         foyerRepository.deleteById(idF);
    }

    @Override
    public Foyer getByNomFoyer(String nomF) {
        return foyerRepository.findByNomFoyer(nomF);
    }

    @Override
    public Foyer getbyUniversite(long idUniversite) {
        return foyerRepository.findByUniversite(universiteRepository.findById(idUniversite).get());
    }
}
