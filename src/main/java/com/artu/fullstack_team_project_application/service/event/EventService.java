package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.event.EventDetailImage;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventOption;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventService {

    Optional<Event> getEventById(int id);

    List<Event> getEventsAllByCategory(byte ctgrId);

    List<Event> getEventsByCategoryForMain(byte ctgrId, Pageable pageable);

    public Optional<Event> getEventById(Integer eventId) ;

    public List<EventDate> getEventDates(Integer eventId) ;


    public List<EventOption> getOptionsByDateId(Integer dateId);

    public List<EventDetailImage> getEventDetailImages(Integer eventId);

    public List<EventReview> getReviewsByEventId(Integer eventId) ;

    public List<EventReviewImage> getReviewImagesByEventId(Integer eventId);


}