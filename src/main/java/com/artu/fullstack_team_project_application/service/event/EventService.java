package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.event.EventImage;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventDetailImage;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventOption;
import com.artu.fullstack_team_project_application.repository.event.EventDetailImageRepository;
import com.artu.fullstack_team_project_application.repository.event.EventRepository;
import com.artu.fullstack_team_project_application.repository.event.EventReviewImageRepository;
import com.artu.fullstack_team_project_application.repository.event.EventReviewRepository;
import com.artu.fullstack_team_project_application.repository.tickets.EventDateRepository;
import com.artu.fullstack_team_project_application.repository.tickets.EventOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventDateRepository eventDateRepository;
    private final EventOptionRepository eventOptionRepository;
    private final EventDetailImageRepository eventDetailImageRepository;
    private final EventReviewRepository eventReviewRepository;
    private final EventReviewImageRepository eventReviewImageRepository;

    public Optional<Event> getEventById(Integer eventId) {
        return eventRepository.findById(eventId);
    }

    public List<EventDate> getEventDates(Integer eventId) {
        return eventDateRepository.findByEventId(eventId);
    }

    public List<EventOption> getOptionsByDateId(Integer dateId) {
        return eventOptionRepository.findByDate_DateId(dateId);
    }

    public List<EventDetailImage> getEventDetailImages(Integer eventId) {
        return eventDetailImageRepository.findByEventId(eventId);
    }

    public List<EventReview> getReviewsByEventId(Integer eventId) {
        return eventReviewRepository.findByEventId(eventId);
    }

    public List<EventReviewImage> getReviewImagesByEventId(Integer eventId) {
        return eventReviewImageRepository.findByEvent_EventId(eventId);
    }
}