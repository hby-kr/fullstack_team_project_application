package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.repository.event.EventReviewImageRepository;
import com.artu.fullstack_team_project_application.service.event.EventReviewImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/review-images")
public class EventReviewImageController {

    private final EventReviewImageService eventReviewImageService;

    public EventReviewImageController(EventReviewImageService eventReviewImageService) {
        this.eventReviewImageService = eventReviewImageService;
    }

    // 특정 유저가 업로드한 리뷰 이미지 조회 (JSON 반환)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EventReviewImage>> getImagesByUser(@PathVariable String userId) {
        List<EventReviewImage> images = eventReviewImageService.getImagesByUserId(userId);
        return ResponseEntity.ok(images);
    }

    // 특정 이미지 ID로 조회 (JSON 반환)
    @GetMapping("/{imageId}")
    public ResponseEntity<EventReviewImage> getImageById(@PathVariable Integer imageId) {
        Optional<EventReviewImage> image = eventReviewImageService.getImageById(imageId);
        return image.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 리뷰 이미지 저장 (POST 요청)
    @PostMapping("/upload")
    public ResponseEntity<EventReviewImage> uploadImage(@RequestBody EventReviewImage eventReviewImage) {
        EventReviewImage savedImage = eventReviewImageService.saveImage(eventReviewImage);
        return ResponseEntity.ok(savedImage);
    }

    // 리뷰 이미지 삭제 (DELETE 요청)
    @DeleteMapping("/delete/{imageId}")
    public ResponseEntity<Void> deleteImage(@PathVariable Integer imageId) {
        eventReviewImageService.deleteImage(imageId);
        return ResponseEntity.noContent().build();
    }

    // 리뷰 이미지 페이지 렌더링 (Thymeleaf 를 활용한 HTML 렌더링)
    @GetMapping("/page")
    public String getReviewImagesPage(Model model) {
        List<EventReviewImage> images = eventReviewImageService.getImagesByUserId("sampleUser"); // 예제 유저
        model.addAttribute("images", images);
        return "event/eventReviewImages"; // templates/event/eventReviewImages.html 페이지로 이동
    }
}