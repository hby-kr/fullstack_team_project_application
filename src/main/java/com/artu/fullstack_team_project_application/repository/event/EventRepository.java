package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {


    List<Event> findByCtgrId(byte ctgrId);
    List<Event> findByCtgrId(byte ctgrId, Pageable pageable);


    // 이벤트를 불러올 때 포스터 이미지는 항상 불러온다.

    // 디테일 이미지는 상세 화면에서만,

    // 리뷰는 리뷰페이지에서만
    // 그러나 리뷰평점을 만들어야 하니 따로 메서드 하나더 구현 해야.

}