package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chamber;
import tn.esprit.springproject.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImp implements IChambre{
    public ChambreRepository chambreRepository;
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
   public List<Chamber> findChambresByBloc(Bloc B) { return chambreRepository.findChambersByBloc(B); }
}
