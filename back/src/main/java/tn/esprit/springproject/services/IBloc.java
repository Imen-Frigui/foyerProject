package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.TypeChambre;

import java.util.List;

public interface IBloc {
    public Bloc addBloc(Bloc B);
    public Bloc updateBloc(Bloc B);
    public List<Bloc> getAllBloc();
    public Bloc getById(long id);
    public void deleteBloc(long id);
    public List<Bloc> findByChamberListTypeC(TypeChambre type);
    public Bloc getBlocByChambreId(long chambreId);
}
