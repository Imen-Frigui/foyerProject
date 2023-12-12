package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Rate;

import java.util.List;
import java.util.Set;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    public Foyer findByNomFoyer(String nomFoyer);
    Set<Foyer> findByRegion(String region);
    Set<Foyer> findByCapacityFoyer(int capacity);
    Set<Foyer> findByUniversite_NomUniversite(String nomU);
    @Query("SELECT COUNT(f) FROM Foyer f WHERE f.region = :region")
    int countFoyersByRegion(@Param("region") String region);
    @Query("SELECT COUNT(c) FROM Foyer f JOIN f.blocList b JOIN b.chamberList c WHERE f.idFoyer = :foyerId")
    int countChambersByFoyerId(@Param("foyerId") long foyerId);
    @Query("SELECT COUNT(r) FROM Foyer f JOIN f.blocList b JOIN b.chamberList c LEFT JOIN c.reservationList r WHERE f.idFoyer = :foyerId and r.estValide = true")
    int countReservationsByFoyerId(@Param("foyerId") long foyerId);
    @Query("SELECT COUNT(b) FROM Foyer f JOIN f.blocList b WHERE f.idFoyer = :foyerId")
    int countBlocsByFoyerId(@Param("foyerId") long foyerId);

    @Query("SELECT AVG(b.capaciteBloc) FROM Foyer f JOIN f.blocList b WHERE f.idFoyer = :foyerId")
    Double getAverageBlocCapacityByFoyerId(@Param("foyerId") Long foyerId);
    @Query("SELECT f FROM Foyer f JOIN f.blocList b WHERE b.capaciteBloc > :capacityVar")
    List<Foyer> findFoyersWithHighCapacityBlocs(@Param("capacityVar") Long capacityVar);

    @Query("SELECT f FROM Foyer f JOIN f.blocList b JOIN b.chamberList c JOIN c.reservationList r GROUP BY f.idFoyer ORDER BY COUNT(r) DESC")
    List<Foyer> getFoyerWithMostReservations();


    @Query("select count(f) from Foyer f")
    int countAll();





}
