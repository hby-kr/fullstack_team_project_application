package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventOption;
import com.artu.fullstack_team_project_application.repository.event.EventDetailImageRepository;
import com.artu.fullstack_team_project_application.repository.event.EventRepository;
import com.artu.fullstack_team_project_application.repository.event.EventReviewImageRepository;
import com.artu.fullstack_team_project_application.repository.event.EventReviewRepository;
import com.artu.fullstack_team_project_application.repository.tickets.EventDateRepository;
import com.artu.fullstack_team_project_application.repository.tickets.EventOptionRepository;
import com.artu.fullstack_team_project_application.entity.events.event.EventDetailImage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventServiceImp implements EventService {

    private final EventRepository eventRepository;
    private final EventDateRepository eventDateRepository;
    private final EventOptionRepository eventOptionRepository;
    private final EventDetailImageRepository eventDetailImageRepository;
    private final EventReviewRepository eventReviewRepository;
    private final EventReviewImageRepository eventReviewImageRepository;

    @Override
    public Optional<Event> getEventById(int id) {
        return eventRepository.findById(id);
        // findById(id)는 Optional<Event>를 반환함
        // 데이터가 있으면 → event에 값이 들어감 / 데이터가 없으면 → event는 null이 됨
    }

    @Override
    public List<Event> getEventsAllByCategory(byte ctgrId) {
     return eventRepository.findByCtgrId(ctgrId);
    }

    @Override
    public List<Event> getEventsByCategoryForMain(byte ctgrId, Pageable pageable) {
        return eventRepository.findByCtgrId(ctgrId, pageable);
    }
    @Override
    public Optional<Event> getEventById(Integer eventId) {
        return eventRepository.findById(eventId);
    }
    @Override
    public List<EventDate> getEventDates(Integer eventId) {
        return eventDateRepository.findByEventId(eventId);
    }
    @Override
    public List<EventOption> getOptionsByDateId(Integer dateId) {
        return eventOptionRepository.findByDate_DateId(dateId);
    }
    @Override
    public List<EventDetailImage> getEventDetailImages(Integer eventId) {
        return eventDetailImageRepository.findByEventId(eventId);
    }
    @Override
    public List<EventReview> getReviewsByEventId(Integer eventId) {
        return eventReviewRepository.findByEventId(eventId);
    }
    @Override
    public List<EventReviewImage> getReviewImagesByEventId(Integer eventId) {
        return eventReviewImageRepository.findByEvent_EventId(eventId);
    }
}