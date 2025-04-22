package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.EventDetailImage;
import com.artu.fullstack_team_project_application.repository.event.EventDetailImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventDetailImageServiceImp implements EventDetailImageService {

    @Autowired
    private final EventDetailImageRepository eventDetailImageRepository;


}
