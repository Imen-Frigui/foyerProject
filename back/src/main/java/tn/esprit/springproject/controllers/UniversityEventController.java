package tn.esprit.springproject.controllers;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.entities.UniversityEvent;
import tn.esprit.springproject.services.IUniversityEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class UniversityEventController {
    private IUniversityEvent iUniversityEvent;

    @GetMapping
    public List<UniversityEvent> getAllEvents() {
        return iUniversityEvent.getAllEvents();
    }

    @GetMapping("/by-university/{universityId}")
    public List<UniversityEvent> getEventsByUniversity(@PathVariable long universityId) {
        Universite university = new Universite();
        university.setIdUniversite(universityId); // Assume you have a method to find university by ID
        return iUniversityEvent.getEventsByUniversity(university);
    }

    @GetMapping("/date-range/{universityId}")
    public List<UniversityEvent> getEventsInDateRange(@PathVariable long universityId,
                                                      @RequestParam String startDate,
                                                      @RequestParam String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedStartDate = dateFormat.parse(startDate);
        Date parsedEndDate = dateFormat.parse(endDate);

        Universite university = new Universite();
        university.setIdUniversite(universityId); // Assume you have a method to find university by ID
        return iUniversityEvent.getEventsInDateRange(university, parsedStartDate, parsedEndDate);
    }

    @GetMapping("/latest/{universityId}")
    public List<UniversityEvent> getLatestEventsForUniversity(@PathVariable long universityId) {
        Universite university = new Universite();
        university.setIdUniversite(universityId); // Assume you have a method to find university by ID
        return iUniversityEvent.getLatestEventsForUniversity(university);
    }

    @PostMapping
    public UniversityEvent createEvent(@RequestBody UniversityEvent event) {
        return iUniversityEvent.createEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable long eventId) {
        iUniversityEvent.deleteEvent(eventId);
    }
}
