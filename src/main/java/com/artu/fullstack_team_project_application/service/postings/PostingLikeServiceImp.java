package com.artu.fullstack_team_project_application.service.postings;

import com.artu.fullstack_team_project_application.entity.postings.PostingLike;
import com.artu.fullstack_team_project_application.repository.postings.PostingLikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class PostingLikeServiceImp implements PostingLikeService {
    private final PostingLikeRepository postingLikeRepository;

    @Override
    public PostingLike save(Integer postId, String userId) {
        if (postId != null && userId != null) {
            PostingLike postingLike = new PostingLike();
            postingLike.setPostId(postId);
            postingLike.setUserId(userId);
            postingLike.setIsUsed(true);
            postingLike.setLikedAt(Instant.now());
            return postingLikeRepository.save(postingLike);
        }else {
            throw new IllegalArgumentException("저장 불가");
        }
    }

    @Override
    public PostingLike delete(String userId, Integer postId) {
        PostingLike postingLike = postingLikeRepository.findByUser_UserIdAndPost_PostId(userId, postId).orElseThrow(() -> new NoSuchElementException("좋아요 없음"));
        postingLikeRepository.delete(postingLike);
        return postingLike;
    }

    // 유저의 좋아요 목록
    @Override
    public Set<PostingLike> findAllByUserId(String userId) {
        return postingLikeRepository.findAllByUserId(userId);
    }

    // 게시물 좋아요 카운트
    @Override
    public Map<String, Long> countPostingLikeByUserId(String userId){
        Long countPostingLikes = postingLikeRepository.countPostingLikes(userId);
        Map<String, Long> countPostingLikeMap = new HashMap<>();
        countPostingLikeMap.put("countPostingLikes", countPostingLikes);
        return countPostingLikeMap;
    }

    // 좋아요 중복 방지
    @Override
    public boolean existsByUserIdAndPostId(String userId, Integer postId) {
        return postingLikeRepository.existsByUser_UserIdAndPost_PostId(userId, postId);
    }
}
