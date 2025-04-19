package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.service.event.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventRestController {

    private final EventService eventService;

    @GetMapping("/cate/{ctgrId}")
    public ResponseEntity<List<Event>> category(@PathVariable byte ctgrId) {
        System.out.println(ctgrId + ": 호출ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ⭐️⭐️⭐️⭐️⭐️⭐️⭐️⭐️⭐️⭐️⭐️️️");
        List<Event> events = eventService.getEventsByCategory(ctgrId);
        //System.out.println(events);
        if (events.isEmpty()) {
            return ResponseEntity.noContent().build(); // 빈 목록일 경우 204 No Content 응답
        }
        return ResponseEntity.ok(events); // 정상적인 경우 200 OK 응답
    }


}
