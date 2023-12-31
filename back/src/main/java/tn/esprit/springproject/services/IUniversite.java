package tn.esprit.springproject.services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface IUniversite {
    public Universite addUniversite(Universite u);

    public Universite updateUniversite(Universite u);

    public List<Universite> findAllUniversite();

    public Universite findById(long idU);

    public void deleteUniversite(long idU);

    public Universite getByNomUniversite(String nomU);

    public List<Foyer> findFoyersNotAssignedToUniversity();

    public List<Universite> searchByName(String name);

    public List<Universite> searchByAddress(String address);

    public List<Universite> searchByFoyer(long foyer);

    public double calculateAverageBlocCapacityForUniversity(long universityId);
}
