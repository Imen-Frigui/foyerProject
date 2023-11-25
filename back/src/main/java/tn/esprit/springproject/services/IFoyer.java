package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Foyer;

import java.util.List;
import java.util.Optional;

public interface IFoyer {
    public Foyer addFoyer(Foyer f);
    public Foyer updateFoyer(Foyer f);
    public List<Foyer> findAllFoyer();
    public Foyer findById(long idF);
    public void deleteFoyer(long idF);
    public Foyer getByNomFoyer(String nomF);
}
