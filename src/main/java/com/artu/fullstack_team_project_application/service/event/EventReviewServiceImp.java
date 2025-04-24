package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.repository.event.EventReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventReviewServiceImp implements EventReviewService {//인터페이스에서 약속했던 기능들을 실제로 구현
    private final EventReviewRepository eventReviewRepository;

}