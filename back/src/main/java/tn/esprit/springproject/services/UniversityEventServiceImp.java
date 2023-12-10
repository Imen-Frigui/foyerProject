package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.entities.UniversityEvent;
import tn.esprit.springproject.repositories.UniversiteRepository;
import tn.esprit.springproject.repositories.UniversityEventRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@AllArgsConstructor
@Slf4j
public class UniversityEventServiceImp implements IUniversityEvent{
    public UniversityEventRepository universityEventRepository;
    public UniversiteRepository universiteRepository;
    public IUniversite iUniversite;

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


    @Scheduled(cron = "0 0 8 * * ?")
    //@Scheduled(fixedRate = 9000)
    public void checkUpcomingEvents() {
        log.info("Scheduled task is running...");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        List<Universite> universities = universiteRepository.findAll();

        for (Universite university : universities) {
            log.info("Checking events for university: " + university.getNomUniversite());
            List<UniversityEvent> upcomingEvents = getEventsInDateRange(university, today, tomorrow);
            for (UniversityEvent event : upcomingEvents) {
                log.info("Upcoming Event: " + event.getEventName() + " on " + event.getEventDate());
                String message= "Upcoming Event: " + event.getEventName() + " on " + event.getEventDate();
                addUpcomingEventMessage(message);
            }
        }

    }

    private List<String> upcomingEventMessages ;

    public void addUpcomingEventMessage(String message) {
        upcomingEventMessages.add(message);
    }

    public List<String> getUpcomingEventMessages() {
        return new ArrayList<>(upcomingEventMessages);
    }

    @Override
    public UniversityEvent createEventAndAssignToUniversity(UniversityEvent event, long universityId) {
        Universite Universite = iUniversite.findById(universityId);

        if (Universite!=null) {
            event.setUniversity(Universite);
            return universityEventRepository.save(event);
        } else {
            return null;
        }
    }
}
