package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;
import com.artu.fullstack_team_project_application.entity.events.event.EventDetailImage;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventOption;
import com.artu.fullstack_team_project_application.service.event.EventService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final 필드나 @NonNull 붙은 필드만 받는 생성자 만듦 → 선택된 필드만 초기화할 수 있음
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
// allowCredentials = "true" 브라우저는 기본적으로 자격 정보가 포함된 요청을 외부 도메인으로 보낼 수 없음.
// 이 설정을 하면, 클라이언트에서 자격 정보를 포함해서 요청 보낼 수 있게 됨.
// 반대로 이 설정 안하면, → 자격 정보 없이 요청만 허용함, 세션 방식 못 씀, 쿠키 방식도 못 씀. 즉, 로그인 상태 유지 안 됨
// 따라서 로그인 후에만 접근 가능한 컨트롤러에는 //@CrossOrigin(..., allowCredentials = "true") 설정 필요함
@RequestMapping("/api/events")
public class EventRestController2 {

    private final EventService eventService;

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable Integer eventId) {
        return eventService.getEventById(eventId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{eventId}/dates")
    public List<EventDate> getEventDates(@PathVariable Integer eventId) {
        return eventService.getEventDates(eventId);
    }

    @GetMapping("/dates/{dateId}/options")
    public List<EventOption> getOptions(@PathVariable Integer dateId) {
        return eventService.getOptionsByDateId(dateId);
    }

    @GetMapping("/{eventId}/images")
    public List<EventDetailImage> getEventDetailImages(@PathVariable Integer eventId) {
        return eventService.getEventDetailImages(eventId);
    }

    @GetMapping("/{eventId}/reviews")
    public List<EventReview> getReviews(@PathVariable Integer eventId) {
        return eventService.getReviewsByEventId(eventId);
    }

    @GetMapping("/{eventId}/review-images")
    public List<EventReviewImage> getReviewImages(@PathVariable Integer eventId) {
        return eventService.getReviewImagesByEventId(eventId);
    }
}
