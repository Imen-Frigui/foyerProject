package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findEtudiantByNomEt(String nom);
    List<Etudiant> findEtudiantByNomEtStartingWith(String nom);
    List<Etudiant> findByReservationList_EstValideTrue();
    @Query("SELECT e FROM Etudiant e WHERE e.idEtudiant IN " +
            "(SELECT et.idEtudiant FROM Etudiant et " +
            "JOIN et.reservationList r " +
            "WHERE EXISTS " +
            "(SELECT 1 FROM Chamber c " +
            "JOIN c.reservationList cr " +
            "JOIN cr.etudiantList cre " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE et = cre AND u.nomUniversite = :universityName))")
    List<Etudiant> findAllByUniversity(@Param("universityName") String universityName);

}
