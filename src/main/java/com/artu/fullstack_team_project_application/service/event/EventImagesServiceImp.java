package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.EventImage;
import com.artu.fullstack_team_project_application.repository.event.EventImagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventImagesServiceImp implements EventImagesService {
    private final EventImagesRepository eventImagesRepository;

    public  EventImagesServiceImp(EventImagesRepository eventImagesRepository) {
        this.eventImagesRepository = eventImagesRepository;
    }

    @Override
    public List<EventImage> getAllEventImages() {
        return (List<EventImage>) eventImagesRepository.findAll();
    }
}
