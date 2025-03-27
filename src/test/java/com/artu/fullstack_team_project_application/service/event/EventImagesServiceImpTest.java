package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.EventImage;
import com.artu.fullstack_team_project_application.repository.event.EventImagesRepository;
import com.artu.fullstack_team_project_application.repository.event.EventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventImagesServiceImpTest {

    @Autowired
    EventImagesService eventImagesService;

    @Autowired
    EventRepository eventRepository;
    @Autowired
    private EventImagesRepository eventImagesRepository;

    @Test
    void getAllEventImages() {
        EventImage eventImage = new EventImage();
        eventImage.setEventId(1);
        eventImage.setImgOrder(1);
        eventImage.setImgUrl("https://dummyimage.com/500x500/808080/fff.jpg");
        eventImagesRepository.save(eventImage);

        List<EventImage> eventImages = eventImagesService.getAllEventImages();
        Assertions.assertEquals(1, eventImages.size());
    }
}