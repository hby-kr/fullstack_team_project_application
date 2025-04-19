package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.repository.event.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventServiceImp implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Optional<Event> getEventById(int id) {
        return eventRepository.findById(id);
        // findById(id)는 Optional<Event>를 반환함
        // 데이터가 있으면 → event에 값이 들어감 / 데이터가 없으면 → event는 null이 됨
    }

    @Override
    public List<Event> getEventsAllByCategory(byte ctgrId) {
     return eventRepository.findByCtgrId(ctgrId);
    }

    @Override
    public List<Event> getEventsByCategoryForMain(byte ctgrId, Pageable pageable) {
        return eventRepository.findByCtgrId(ctgrId, pageable);
    }
}