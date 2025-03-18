package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.repository.event.EventReviewImageRepository;
import com.artu.fullstack_team_project_application.service.event.EventReviewImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // 파일 저장 (로컬 저장 예시)
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String filePath = "src/main/resources/static/images/" + fileName;
            file.transferTo(new File(filePath));

            // 저장된 파일의 URL 생성
            String imgUrl = "/images/" + fileName;

            return ResponseEntity.ok(imgUrl); // 클라이언트에게 URL 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 실패");
        }
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

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<EventReviewImage>> getImagesByEventId(@PathVariable Integer eventId) {
        List<EventReviewImage> images = eventReviewImageService.getImagesByEventId(eventId);
        return ResponseEntity.ok(images);
    }

}