package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.tickets.EventDetailImage;
import com.artu.fullstack_team_project_application.repository.event.EventDetailImageRepository;
import com.artu.fullstack_team_project_application.repository.event.EventImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventDetailImageServiceImp implements EventDetailImageService {
    private final EventDetailImageRepository eventDetailImageRepository;

    public EventDetailImageServiceImp(EventDetailImageRepository eventDetailImageRepository) {
        this.eventDetailImageRepository = eventDetailImageRepository;
    }

    @Override
    public List<EventDetailImage> getEventDetailImagesByEventId(int eventId) {
        return eventDetailImageRepository.findByEventId(eventId);
    }
}
