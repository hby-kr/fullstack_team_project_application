package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.event.EventImage;
import com.artu.fullstack_team_project_application.repository.event.EventImagesRepository;
import com.artu.fullstack_team_project_application.service.event.EventImagesServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/event-images")
@RequiredArgsConstructor
public class EventImagesController {

    private final EventImagesRepository eventImagesRepository;
    private final EventImagesServiceImp eventImagesServiceImp;

    @GetMapping("/{imageId}")
    public String eventImages(Model model, @PathVariable int imageId) {
        List<EventImage> images = eventImagesRepository.findByEventId(1);
        model.addAttribute("images", images);
        return "event/images";
    }
}
