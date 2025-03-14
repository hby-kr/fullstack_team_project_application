package com.artu.fullstack_team_project_application.repository.postings;

import com.artu.fullstack_team_project_application.entity.postings.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Integer> {
    // 논리적 삭제 목록 확인
    List<Posting> findByIsUsedFalse();

    // user의 게시글 조회
    List<Posting> findByUser_UserId(String userId);

    // 위치 태그
    // List<Posting> findByLocationTag(String locationTag);

    // 사람 태그
    // List<Posting> findByPersonTagId(String personTagId);
}
