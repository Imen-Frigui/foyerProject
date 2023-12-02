package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNom(String nom);
    Optional<User> findByEmail(String email);
    List<User> findByNomStartingWith(String nom);
    List<User> findByReservationList_EstValideTrue();
    @Query("SELECT e FROM User e WHERE e.idUser IN " +
            "(SELECT et.idUser FROM User et " +
            "JOIN et.reservationList r " +
            "WHERE EXISTS " +
            "(SELECT 1 FROM Chamber c " +
            "JOIN c.reservationList cr " +
            "JOIN cr.userList cre " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE et = cre AND u.nomUniversite = :universityName))")
    List<User> findAllByUniversity(@Param("universityName") String universityName);

}
