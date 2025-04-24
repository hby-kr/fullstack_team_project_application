package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.Actor;
import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.event.EventCast;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventCastRepository extends CrudRepository<EventCast, Integer> {

    @EntityGraph(attributePaths = {"EventCast.actor"})
    List<EventCast> findByEventId(int eventId);
    /* EventCast.actor에서 @JsonBackReference 어노테이션을 빼면,
    Spring은 EventCasting 안에 있는 Actor 정보를 JSON으로 바꿔서 보내려고 해.
    근데 Actor는 Lazy 방식으로 불러오게 되어 있어서, 필요할 때만 불러오려고 대기 상태야.
    그래서 Spring이 이걸 JSON으로 바꾸려고 하면, 아직 준비가 안 된 배우(Actor) 정보인데, json으로 보내려니까. 에러가 나게 되는 것.
    JSON에 포함되도록 하고 싶으면, EventCasting 안의 actor를 미리 DB에서 불러오도록 설정해야 해.
    그게 강제조인  @EntityGraph(attributePaths = {"EventCast.actor"}) 설정이야.  */
}