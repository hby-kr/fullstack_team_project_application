package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.service.event.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
@CrossOrigin(value = "http://localhost:5173") // 리소스 쉐어를 허용하는 서버를 추가
public class EventRestController {

    private final EventService eventService;

    @GetMapping("/cate/{ctgrId}/{pageSize}")
    public ResponseEntity<List<Event>> getEventsByctgrId(
            @PathVariable("ctgrId") byte ctgrId,
            @PathVariable("pageSize") int size
    ) {
        PageRequest pageRequest = PageRequest.of(0, size);
        List<Event> events = eventService.getEventsByCategoryForMain(ctgrId, pageRequest);

        if (events.isEmpty()) {
            return ResponseEntity.noContent().build(); // 빈 목록일 경우 204 No Content 응답
        }
        return ResponseEntity.ok(events); // 정상적인 경우 200 OK 응답
    }


    @GetMapping("/cate/{ctgrId}")
    public ResponseEntity<List<Event>> categoryAll(@PathVariable byte ctgrId) {
        List<Event> events = eventService.getEventsAllByCategory(ctgrId);
        //System.out.println(events);
        if (events.isEmpty()) {
            return ResponseEntity.noContent().build(); // 빈 목록일 경우 204 No Content 응답
        }
        return ResponseEntity.ok(events); // 정상적인 경우 200 OK 응답
    }


    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable int eventId) {
        Optional<Event> event = eventService.getEventById(eventId);
        return event
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build()); // 예외관리 조건문 함수형으로 써봄.
    }

}
