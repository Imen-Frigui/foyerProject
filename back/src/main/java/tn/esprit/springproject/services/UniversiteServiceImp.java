package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.FoyerRepository;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversite{
    public UniversiteRepository universiteRepository;
    public FoyerRepository foyerRepository;
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

    @Override
    public List<Foyer> findFoyersNotAssignedToUniversity() {
        return foyerRepository.findByUniversiteIsNull();
    }

    @Override
    public List<Universite> searchByName(String name) {
        return universiteRepository.findByNomUniversiteContainingIgnoreCase(name);
    }

    @Override
    public List<Universite> searchByAddress(String address) {
        return universiteRepository.findByAdresseUniversiteContainingIgnoreCase(address);
    }

    @Override
    public List<Universite> searchByFoyer(long idF) {
        return universiteRepository.findByFoyer_IdFoyer(idF);
    }

    public Universite addUniversityAndAssignToFoyer(Universite universite, Foyer foyer) {
        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }

    @Override
    public double calculateAverageBlocCapacityForUniversity(long universityId) {
        Universite university = universiteRepository.findById(universityId).orElse(null);
        if (university == null || university.getFoyer() == null) {
            return 0.0;
        }

        Foyer foyer = university.getFoyer();
        List<Bloc> blocs = foyer.getBlocList();

        if (blocs.isEmpty()) {
            return 0.0;
        }

        long totalCapacity = 0;
        for (Bloc bloc : blocs) {
            totalCapacity += bloc.getCapaciteBloc();
        }

        return (double) totalCapacity / blocs.size();
    }
}
