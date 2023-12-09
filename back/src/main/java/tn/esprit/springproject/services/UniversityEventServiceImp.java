package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.entities.UniversityEvent;
import tn.esprit.springproject.repositories.UniversityEventRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UniversityEventServiceImp implements IUniversityEvent{
    public UniversityEventRepository universityEventRepository;

    @Override
    public List<UniversityEvent> getAllEvents() {
        return universityEventRepository.findAll();
    }

    @Override
    public List<UniversityEvent> getEventsByUniversity(Universite university) {
        return universityEventRepository.findByUniversity(university);
    }

    @Override
    public List<UniversityEvent> getEventsInDateRange(Universite university, Date startDate, Date endDate) {
        return universityEventRepository.findByUniversityAndEventDateBetween(university, startDate, endDate);
    }
    @Override
    public List<UniversityEvent> getLatestEventsForUniversity(Universite university) {
        // Assume you want to get the latest 'count' events for a university
        return universityEventRepository.findLatestEventForUniversity(university);
    }

    @Override
    public UniversityEvent createEvent(UniversityEvent event) {
        return universityEventRepository.save(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        universityEventRepository.deleteById(eventId);
    }
}
