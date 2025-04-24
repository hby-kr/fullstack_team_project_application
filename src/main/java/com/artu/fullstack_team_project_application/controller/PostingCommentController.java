package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.postings.Posting;
import com.artu.fullstack_team_project_application.entity.postings.PostingComment;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.service.postings.PostingCommentService;
import com.artu.fullstack_team_project_application.service.postings.PostingService;
import com.artu.fullstack_team_project_application.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;

//@Controller
@RestController
@RequestMapping("/posting")
@AllArgsConstructor
public class PostingCommentController {
    private final PostingService postingService;
    private final PostingCommentService postingCommentService;
    private final UserService userService;

    @PostMapping("/comments.do")
    public ResponseEntity<PostingComment> save(
            @RequestParam Integer postId,
            @RequestParam String content,
            @RequestParam String userId
    ) {
        Posting post = postingService.findByPostId(postId);
        User user = userService.readOne(userId).orElseThrow(() -> new NoSuchElementException("없음"));
        PostingComment savedComment = postingCommentService.save(post, content, user);
//        PostingComment savedComment = postingCommentService.save(post, content, user);
        return ResponseEntity.ok(savedComment);
    }

    @DeleteMapping("/comments.do")
    public ResponseEntity<PostingComment> delete(
            @RequestParam Integer commentId
    ) {
        PostingComment deletedComment = postingCommentService.delete(commentId);
        return ResponseEntity.ok(deletedComment);
    }

    @GetMapping("/comment/userId.do")
    public ResponseEntity<Set<PostingComment>> findAllByUserId(@RequestParam String userId) {
        Set<PostingComment> commentsUserId = postingCommentService.findByUser_UserId(userId);
        return ResponseEntity.ok(commentsUserId);
    }

    @GetMapping("/comment/postId.do")
    public ResponseEntity<Set<PostingComment>> findAllByPostIdResponse(@RequestParam Integer postId) {
        Set<PostingComment> commentsPostId = postingCommentService.findCommentsByPost_PostId(postId);
        return ResponseEntity.ok(commentsPostId);
    }



}
