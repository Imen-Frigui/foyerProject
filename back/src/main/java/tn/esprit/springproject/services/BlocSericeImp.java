package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chamber;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.TypeChambre;
import tn.esprit.springproject.repositories.BolcRepository;
import tn.esprit.springproject.repositories.ChambreRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocSericeImp implements IBloc {

    public BolcRepository bolcRepository;
    public ChambreRepository chambreRepository;
    @Override
    public Bloc addBloc(Bloc B) { return bolcRepository.save(B); }
    @Override
    public Bloc updateBloc(Bloc B) { return bolcRepository.save(B); }
    @Override
    public List<Bloc> getAllBloc() { return bolcRepository.findAll(); }
    @Override
    public Bloc getById(long id) { return bolcRepository.findById(id).orElse(null); }
    @Override
    public void deleteBloc(long id) { bolcRepository.deleteById(id); }
    @Override
    public List<Bloc> findByChamberListTypeC(TypeChambre type) {
        return bolcRepository.findByChamberListTypeC(type);
    }

    @Override
    public Bloc getBlocByChambreId(long chambreId) {
        Chamber chambre = chambreRepository.findById(chambreId).orElse(null);
        if (chambre!=null){
            return chambre.getBloc();
        }else {
            return null;
        }
    }

}
