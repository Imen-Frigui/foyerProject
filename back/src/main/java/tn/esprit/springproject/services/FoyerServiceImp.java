package tn.esprit.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Rate;
import tn.esprit.springproject.repositories.FoyerRepository;
import tn.esprit.springproject.repositories.RateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FoyerServiceImp implements IFoyer {

    @Autowired
    private FoyerRepository foyerRepository;
    @Autowired
    private RateRepository rateRepository;

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

    public Set<Foyer> getByRegionFoyer(String region) {
        return foyerRepository.findByRegion(region);
    }

    public Page<Foyer> findAllFoyer(Pageable pageable) {
        return foyerRepository.findAll(pageable);
    }

    public Set<Foyer> findFoyerByCapacity(int c) {
        return foyerRepository.findByCapacityFoyer(c);
    }

    public int countBlocsByFoyerId(long f) {
        return foyerRepository.countBlocsByFoyerId(f);
    }

    public Double getAverageBlocCapacityByFoyerId(@PathVariable Long foyerId) {
        return foyerRepository.getAverageBlocCapacityByFoyerId(foyerId);
    }

    public List<Foyer> findFoyersWithHighCapacityBlocs(@PathVariable Long capacityVar) {
        return foyerRepository.findFoyersWithHighCapacityBlocs(capacityVar);
    }

    public List<Foyer> getFoyerWithMostReservations() {
        return foyerRepository.getFoyerWithMostReservations();
    }

    public void generateYearlyReportForFoyers() {
        List<Foyer> allFoyers = foyerRepository.findAll();

        for (Foyer foyer : allFoyers) {
            long totalBlocCount = foyerRepository.countBlocsByFoyerId(foyer.getIdFoyer());
            int totalChamberCount = foyerRepository.countChambersByFoyerId(foyer.getIdFoyer());
            int totalReservationCount = foyerRepository.countReservationsByFoyerId(foyer.getIdFoyer());
            System.out.println("Generated yearly report for Foyer: " + foyer.getNomFoyer());
            System.out.println("Total Blocs: " + totalBlocCount);
            System.out.println("Total Chambers: " + totalChamberCount);
            System.out.println("Total Reservations: " + totalReservationCount);
        }
    }

    public int countFoyersByRegion(String region) {
        return foyerRepository.countFoyersByRegion(region);
    }
    public double calculateAverageRatingForFoyer(long  idFoyer) {
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        List<Rate> ratings = new ArrayList<>();
        ratings.addAll(f.getRatingList());
        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }
        int sum = ratings.stream().mapToInt(Rate::getRateNumber).sum();
        return (double) sum / ratings.size();
    }

    public List<Rate> findRateByFoyer(Long idF){
        Foyer f = foyerRepository.findById(idF).orElse(null);
        List<Rate> ratings = new ArrayList<>();
        ratings.addAll(f.getRatingList());
        return ratings;
    }

    public Rate addRatingForFoyer(Rate r,Long idF){
        Foyer f = foyerRepository.findById(idF).orElse(null);
        f.getRatingList().add(r);
        foyerRepository.save(f);
        return r;
    }


   public int countAll(){
        return foyerRepository.countAll();
    }


}