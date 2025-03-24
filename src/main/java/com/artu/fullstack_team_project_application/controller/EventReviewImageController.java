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
        if (image.isPresent()) {
            return ResponseEntity.ok(image.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/upload") // 사진을 업로드하는 API
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {//MultipartFile file 사용자가 올린 파일 받음
        try {
            // 파일 저장 (로컬 저장)
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String filePath = "src/main/resources/static/img/" + fileName; // src/main/resources/static/img/폴더에 저장
            file.transferTo(new File(filePath));

            // 저장된 파일의 URL 생성
            String imgUrl = "/img/" + fileName;

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
    @GetMapping("/page")//웹 페이지를 열어서 리뷰 사진들 보여주기
    public String getReviewImagesPage(Model model) {
        List<EventReviewImage> images = eventReviewImageService.getImagesByUserId("user1");
        model.addAttribute("images", images); //웹 페이지에서 images 라는 이름으로 사진 데이터를 넘겨줌
        return "event/eventReview"; // templates/event/eventReview.html 페이지로 이동
    }

    // 공연 이미지에 대한 리뷰 사진을 가져오기
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<EventReviewImage>> getImagesByEventId(@PathVariable Integer eventId) {
        List<EventReviewImage> images = eventReviewImageService.getImagesByEventId(eventId);
        return ResponseEntity.ok(images);
    }

}
