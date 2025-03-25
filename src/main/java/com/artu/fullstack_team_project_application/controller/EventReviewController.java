package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.repository.event.EventReviewRepository;
import com.artu.fullstack_team_project_application.service.event.EventReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class EventReviewController {

    private final EventReviewService eventReviewService;

    public EventReviewController(EventReviewService eventReviewService) {
        this.eventReviewService = eventReviewService;
    }


    @GetMapping("/{eventId}")
    public String getReviewsByEvent(@PathVariable Integer eventId, Model model) {
        List<EventReview> reviews=eventReviewService.getReviewsByEventId(eventId);
        return "eventReview";
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EventReview>> getReviewsByUserId(@PathVariable String userId) {
        List<EventReview> reviews=eventReviewService.getReviewsByUserId(userId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/create")
    public ResponseEntity<EventReview> createReview(@RequestBody EventReview eventReview) {
        EventReview createReview = eventReviewService.createReview(eventReview);
        return ResponseEntity.ok(createReview);
    }

    @PostMapping("/update/{reviewId}")
    public ResponseEntity<EventReview> updateReview(
            @PathVariable Integer reviewId,
            @RequestBody EventReview reviewDetails
    ) {
        EventReview updateReview = eventReviewService.updateReview(reviewId, reviewDetails.getContents(), reviewDetails.getRate());
        return ResponseEntity.ok(updateReview);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer reviewId) {
        eventReviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list.do")
    public String getAllReviews(Model model) {
        List<EventReview> reviews = eventReviewService.getAllEventReviews();
        model.addAttribute("reviews", reviews);
        return "event/eventReview"; // eventReview.html 을 반환
    }


}
