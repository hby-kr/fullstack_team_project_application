package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.tickets.EventDetailImage;

import java.util.List;

public interface EventDetailImageService {
    List<EventDetailImage> getEventDetailImagesByEventId(int eventId);
}
