package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.entities.UniversityEvent;

import java.util.Date;
import java.util.List;

public interface IUniversityEvent {
    public List<UniversityEvent> getAllEvents() ;

    public List<UniversityEvent> getEventsByUniversity(Universite university) ;

    public List<UniversityEvent> getEventsInDateRange(Universite university, Date startDate, Date endDate) ;

    public List<UniversityEvent> getLatestEventsForUniversity(Universite university);

    public UniversityEvent createEvent(UniversityEvent event) ;

    public void deleteEvent(long eventId) ;
    UniversityEvent createEventAndAssignToUniversity(UniversityEvent event, long universityId);

}
