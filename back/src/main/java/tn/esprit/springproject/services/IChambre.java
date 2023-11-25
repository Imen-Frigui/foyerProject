package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chamber;

import java.util.List;

public interface IChambre {
    public Chamber addChamber(Chamber C);
    public Chamber updateChamber(Chamber C);
    public List<Chamber> getAllChamber();
    public Chamber getChamberById(long id);
    public void deleteChamber(long id);
    public List<Chamber> findChambresByBloc(Bloc B);
}
