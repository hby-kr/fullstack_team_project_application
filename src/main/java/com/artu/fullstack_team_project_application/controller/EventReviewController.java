package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.repository.event.EventReviewRepository;
import com.artu.fullstack_team_project_application.repository.users.UserRepository;
import com.artu.fullstack_team_project_application.service.event.EventReviewImageService;
import com.artu.fullstack_team_project_application.service.event.EventReviewService;
import com.artu.fullstack_team_project_application.service.event.EventService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class EventReviewController {

    private final EventService eventService;
    private final EventReviewService eventReviewService;
    private final EventReviewImageService eventReviewImageService;
    private final UserRepository userRepository;

    public EventReviewController(EventService eventService, EventReviewService eventReviewService, EventReviewImageService eventReviewImageService, UserRepository userRepository) {
        this.eventService = eventService;
        this.eventReviewService = eventReviewService;
        this.eventReviewImageService = eventReviewImageService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{eventId}")
    public String getReviewsByEvent(@PathVariable Integer eventId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user"); // 브라우저가 계속 요청해도 서버에서 이 사용자가 누군지 기억 (세션관리)
        model.addAttribute("user", user); // user 객체를 View 로 전달(${user}로 사용)

        List<EventReview> reviews = eventReviewService.getReviewsByEventId(eventId);
        List<EventReviewImage> images = eventReviewImageService.getImagesByEvent_EventId(eventId);
        model.addAttribute("reviews", reviews);
        model.addAttribute("images", images);

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
        model.addAttribute("headerNav", "reviews");
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
            @RequestParam(value = "file", required = false) MultipartFile file) {

        try {
            // 로그인 유저 가져오기 (세션 or Principal에서)
            String userId = "user2001"; // 예시
            User user = userRepository.findById(userId).orElseThrow();
            Event event = eventService.get(eventId).orElseThrow();

            EventReview review = new EventReview();
            review.setUser(user);
            review.setEvent(event);
            review.setEventId(event.getId());
            review.setRate(rate);
            review.setContents(contents);
            review.setCreatedAt(LocalDateTime.now());
            review.setIsUsed(true);
            EventReview savedReview = eventReviewService.registerReview(review);

//            // 이미지 저장
//            if (file != null && !file.isEmpty()) {
//                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//                String uploadPath = "src/main/resources/static/img/";
//
//                File uploadDir = new File(uploadPath);
//                if (!uploadDir.exists()) {
//                    uploadDir.mkdirs();
//                }
//
//                file.transferTo(new File(uploadPath + fileName));
//
//                EventReviewImage img = new EventReviewImage();
//                img.setEventReview(savedReview);
//                img.setImgUrl("/img/" + fileName);
//                eventReviewImageService.saveImage(img);
//            }

            return ResponseEntity.ok("리뷰 등록 성공");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("리뷰 등록 실패");
        }
    }

}


