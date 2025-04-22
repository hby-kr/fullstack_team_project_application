package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.postings.PostingLike;
import com.artu.fullstack_team_project_application.service.postings.PostingLikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

//@Controller
@RestController
@RequestMapping("/posting")
@AllArgsConstructor
public class PostingLikeController {
    private final PostingLikeService postingLikeService;

    @PostMapping("/postlikepage.do")
    public ResponseEntity<PostingLike> savePostLike (
            @RequestParam Integer postId,
            @RequestParam String userId
    ) {
        PostingLike postLike = postingLikeService.save(postId, userId);
        return ResponseEntity.ok(postLike);
    }

    @DeleteMapping("/postlikepage.do")
    public ResponseEntity<PostingLike> deletePostLike (
            @RequestParam Integer postId,
            @RequestParam String userId
    ) {
        postingLikeService.delete(userId, postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/like/post.do")
    public ResponseEntity<Set<PostingLike>> findAllByUserId (@RequestParam String userId) {
        Set<PostingLike> likes = postingLikeService.findAllByUserId(userId);
        for (PostingLike like : likes) {
            like.getPost().getContents();
        }
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/like/count.do")
    public ResponseEntity<Map<String, Long>> countPostingLikeByUserId (@RequestParam String userId) {
        Map<String, Long> countPostingLikeMap = postingLikeService.countPostingLikeByUserId(userId);
        return ResponseEntity.ok(countPostingLikeMap);
    }

    @GetMapping("/like/check.do")
    public ResponseEntity<Boolean> existsByUserIdAndPostId (@RequestParam String userId, @RequestParam Integer postId) {
        boolean exists = postingLikeService.existsByUserIdAndPostId(userId, postId);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/like/exists.do")
    public ResponseEntity<Map<String, Object>> existsByUserIdAndPostIdResponse (@RequestParam String userId, @RequestParam Integer postId) {
        boolean exists = postingLikeService.existsByUserIdAndPostId(userId, postId);
        Map<String, Object> result = Map.of("exists", exists, "postId", postId, "userId", userId);
        return ResponseEntity.ok(result);
    }



}
