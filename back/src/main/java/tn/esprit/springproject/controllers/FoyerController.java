package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Rate;
import tn.esprit.springproject.services.FoyerServiceImp;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/foyer")
@Tag(name = "foyer API")
public class FoyerController {
    @Autowired
    private FoyerServiceImp foyerServiceImp;

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return foyerServiceImp.addFoyer(f);
    }

    @PutMapping("/edit")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return foyerServiceImp.updateFoyer(f);
    }

    @GetMapping("/get/{IdF}")
    public Foyer findFoyerById(@PathVariable long IdF) {
        return foyerServiceImp.findById(IdF);
    }

    @DeleteMapping("/delete/{IdF}")
    public void deleteFoyerById(@PathVariable long IdF) {
        foyerServiceImp.deleteFoyer(IdF);
    }

    @GetMapping("/getbynom/{nomf}")
    public Foyer getByNom(@PathVariable String nomf) {
        return foyerServiceImp.getByNomFoyer(nomf);
    }

    @GetMapping("/getByRegion/{region}")
    public Set<Foyer> getByRegion(@PathVariable String region) {
        return foyerServiceImp.getByRegionFoyer(region);
    }

    @GetMapping("/get")
    public Page<Foyer> findAllFoyer(Pageable pageable) {
        return foyerServiceImp.findAllFoyer(pageable);
    }


    @GetMapping("/countBloc/{idf}")
    public int countBlocsByFoyerId(@PathVariable int idf) {
        return foyerServiceImp.countBlocsByFoyerId(idf);
    }

    @GetMapping("/averageBlocCapacity/{foyerId}")
    public ResponseEntity<Double> getAverageBlocCapacityByFoyerId(@PathVariable Long foyerId) {
        Double averageCapacity = foyerServiceImp.getAverageBlocCapacityByFoyerId(foyerId);
        return ResponseEntity.ok(averageCapacity);
    }

    @GetMapping("/highCapacityFoyers/{capacityVar}")
    public ResponseEntity<List<Foyer>> findFoyersWithHighCapacityBlocs(@PathVariable Long capacityVar) {
        List<Foyer> foyers = foyerServiceImp.findFoyersWithHighCapacityBlocs(capacityVar);
        return ResponseEntity.ok(foyers);
    }

    @GetMapping("/foyerWithMostReservations")
    public ResponseEntity<List<Foyer>> getFoyerWithMostReservations() {
        List<Foyer> foyers = foyerServiceImp.getFoyerWithMostReservations();
        return ResponseEntity.ok(foyers);
    }

//    @Scheduled(cron = "* * 11 * * *")
//    public void generateYearlyReportForFoyers() {
//        foyerServiceImp.generateYearlyReportForFoyers();
//    }

    @GetMapping("/countByRegion/{region}")
    public int countFoyersByRegion(@PathVariable String region) {
        return foyerServiceImp.countFoyersByRegion(region);
    }

    @GetMapping("/getRating/{Idfoyer}")
    public double calculateAverageRatingForFoyer(@PathVariable long Idfoyer) {
        return foyerServiceImp.calculateAverageRatingForFoyer(Idfoyer);
    }

    @GetMapping("/getRatingByFoyer/{Idfoyer}")
    public List<Rate> findAllRateByFoyer(@PathVariable Long Idfoyer) {

        return foyerServiceImp.findRateByFoyer(Idfoyer);
    }

    @PostMapping("/addRatingForFoyer/{idF}")
    public Rate addRatingForFoyer(@RequestBody Rate r, @PathVariable Long idF) {
        r.setDate(new Date());
        return foyerServiceImp.addRatingForFoyer(r, idF);
    }

    @GetMapping("/countAll")
    int countAll() {
        return foyerServiceImp.countAll();
    }

    @GetMapping("/getbyUniversite/{idUniversite}")
    public Foyer getbyUniversite(@PathVariable long idUniversite){
        return foyerServiceImp.getbyUniversite(idUniversite);
    }
}
