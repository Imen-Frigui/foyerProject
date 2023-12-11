package tn.esprit.springproject.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chamber;
import tn.esprit.springproject.repositories.BolcRepository;
import tn.esprit.springproject.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImp implements IChambre {
    public ChambreRepository chambreRepository;
    public BolcRepository blocrep;
    @Override
    public Chamber addChamber(Chamber C) {
        return chambreRepository.save(C);
    }

    @Override
    public Chamber updateChamber(Chamber C) {
        return chambreRepository.save(C);
    }

    @Override
    public List<Chamber> getAllChamber() {
        return chambreRepository.findAll();
    }

    @Override
    public Chamber getChamberById(long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteChamber(long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public List<Chamber> findChambresByBloc(Bloc B) {
        return chambreRepository.findChambersByBloc(B);
    }

    @Override
    public Chamber CreateChamberAndAddToBloc(Chamber C, long BlocId) {

        Bloc  bloc=  blocrep.findById(BlocId).orElse(null);
C.setBloc(bloc);

        return chambreRepository.save(C) ;
    }

//    public List<Chamber> getAvailableChambers() {
//        return chambreRepository.getAvailableChambers();
//
//    }

    @Transactional
    public int bulkCreateChambers(List<Chamber> chambers) {
     return   chambreRepository.saveAll(chambers).size();
    }
}

