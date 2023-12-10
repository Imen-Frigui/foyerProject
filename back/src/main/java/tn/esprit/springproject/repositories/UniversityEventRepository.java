package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.entities.UniversityEvent;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface UniversityEventRepository extends JpaRepository<UniversityEvent, Long> {
    List<UniversityEvent> findByUniversity(Universite universite);
    List<UniversityEvent> findByUniversityAndEventDateBetween(Universite university, Date startDate, Date endDate);
    @Query("SELECT ue FROM UniversityEvent ue WHERE ue.university = :university ORDER BY ue.eventDate DESC")
    List<UniversityEvent> findLatestEventForUniversity(@Param("university") Universite university);
}


