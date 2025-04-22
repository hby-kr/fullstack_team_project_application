package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;
import com.artu.fullstack_team_project_application.entity.events.event.EventDetailImage;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventOption;
import com.artu.fullstack_team_project_application.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequestMapping("/api/events")
public class EventRestController2 {

    private final EventService eventService;

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable Integer eventId) {
        return eventService.getEventById(eventId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{eventId}/dates")
    public List<EventDate> getEventDates(@PathVariable Integer eventId) {
        return eventService.getEventDates(eventId);
    }

    @GetMapping("/dates/{dateId}/options")
    public List<EventOption> getOptions(@PathVariable Integer dateId) {
        return eventService.getOptionsByDateId(dateId);
    }

    @GetMapping("/{eventId}/images")
    public List<EventDetailImage> getEventDetailImages(@PathVariable Integer eventId) {
        return eventService.getEventDetailImages(eventId);
    }

    @GetMapping("/{eventId}/reviews")
    public List<EventReview> getReviews(@PathVariable Integer eventId) {
        return eventService.getReviewsByEventId(eventId);
    }
//
//    @GetMapping("/{eventId}/review-images")
//    public List<EventReviewImage> getReviewImages(@PathVariable Integer eventId) {
//        return eventService.getReviewImagesByEventId(eventId);
//    }
}
