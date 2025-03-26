package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.service.event.EventServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {
    private final EventServiceImp eventServiceImp;


    @GetMapping("/event")
    public String event(Model model) {
        List<Event> events = eventServiceImp.getAllEvents();
        model.addAttribute("events", events);
        return "event/event";
    }
    @GetMapping("/{eventId}/event")
    public String eventDetail(
            @PathVariable int eventId,
            Model model
    ){
        Optional<Event> eventOpt= eventServiceImp.get(eventId);
        Event event = eventOpt.get();
        if(event==null){
            return "redirect:/event/event";
        }else{
            model.addAttribute("event", event);
            return "event/eventdetail";
        }
    }
    @GetMapping("/event/{ctgrId}")
    public String eventCategory(Model model, @PathVariable int ctgrId) {
    List<Event> events = eventServiceImp.getEventsByCategory(ctgrId);
    model.addAttribute("events", events);
    return "event/event";
    }
}

