package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.repository.event.EventReviewRepository;
import com.artu.fullstack_team_project_application.service.event.EventReviewImageService;
import com.artu.fullstack_team_project_application.service.event.EventReviewService;
import com.artu.fullstack_team_project_application.service.event.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class EventReviewController {

    private final EventService eventService;
    private final EventReviewService eventReviewService;
    private final EventReviewImageService eventReviewImageService;

    public EventReviewController(EventService eventService, EventReviewService eventReviewService, EventReviewImageService eventReviewImageService) {
        this.eventService = eventService;
        this.eventReviewService = eventReviewService;
        this.eventReviewImageService = eventReviewImageService;
    }

    @GetMapping("/{eventId}")
    public String getReviewsByEvent(@PathVariable Integer eventId, Model model) {
        List<EventReview> reviews = eventReviewService.getReviewsByEventId(eventId);
        model.addAttribute("reviews", reviews);

        Optional<Event> eventOpt=eventService.get(eventId);
        if (eventOpt.isPresent()) {
            model.addAttribute("event", eventOpt.get());
        } else {
            return "redirect:/not-found";
        }
        return "event/eventReview";
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EventReview>> getReviewsByUserId(@PathVariable String userId) {
        List<EventReview> reviews = eventReviewService.getReviewsByUserId(userId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/create")
    public ResponseEntity<EventReview> createReview(@RequestBody EventReview eventReview) {
        EventReview createReview = eventReviewService.registerReview(eventReview);
        return ResponseEntity.ok(createReview);
    }

    @PostMapping("/update/{reviewId}")
    public ResponseEntity<EventReview> updateReview(
            @PathVariable Integer reviewId,
            @RequestBody EventReview reviewDetails
    ) {
        EventReview updateReview = eventReviewService.saveReview(reviewId, reviewDetails.getContents(), reviewDetails.getRate());
        return ResponseEntity.ok(updateReview);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer reviewId) {
        eventReviewService.removeReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list.do")
    public String getAllReviews(Model model) {
        List<EventReview> reviews = eventReviewService.getAllEventReviews();
        model.addAttribute("reviews", reviews);
        return "event/eventReview";
    }

    @GetMapping("/form")
    public String reviewForm(@RequestParam("eventId") Integer eventId, Model model) {
        Optional<Event> eventOpt=eventService.get(eventId);

        if (eventOpt.isEmpty()){
            return "redirect:/not-found";
        }
        model.addAttribute("event", eventOpt.get());
        return "event/eventReviewForm";
    }

    @PostMapping("/with-image")
    public ResponseEntity<String> createReviewWithImage(
            @RequestParam("eventId") Integer eventId,
            @RequestParam("rate") Integer rate,
            @RequestParam("contents") String contents,
            @RequestParam(value = "file", required = false) MultipartFile file,
            Principal principal
    ) {
        try {
            String userId = principal.getName(); // 로그인된 사용자 ID

            // 1. 리뷰 저장
            EventReview review = new EventReview();
            review.setEvent(new Event() {{
                setId(eventId);
            }});
            review.setUser(new User() {{
                setUserId(userId);
            }});
            review.setRate(rate);
            review.setContents(contents);
            review.setCreatedAt(java.time.LocalDateTime.now());
            review.setIsUsed(true);

            EventReview savedReview = eventReviewService.registerReview(review);

            // 2. 이미지 저장
            if (file != null && !file.isEmpty()) {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                String uploadPath = "src/main/resources/static/img/";
                File dest = new File(uploadPath + fileName);
                file.transferTo(dest);

                String imgUrl = "/img/" + fileName;

                EventReviewImage image = new EventReviewImage();
                image.setEventReview(savedReview);
                image.setUserId(userId);
                image.setEventId(eventId);
                image.setImgUrl(imgUrl);

                // 이미지 저장 서비스 호출
                eventReviewImageService.saveImage(image);
            }

            return ResponseEntity.ok("리뷰+이미지 등록 완료");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("등록 실패");
        }
    }
}

