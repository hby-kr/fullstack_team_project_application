package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetailId;
import com.artu.fullstack_team_project_application.repository.users.UserRepository;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetDetailRepository;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WidgetDetailService {

    private final WidgetDetailRepository widgetDetailRepository;
    private final WidgetRepository widgetRepository;
    private final UserRepository userRepository;

    @Autowired
    public WidgetDetailService(WidgetDetailRepository widgetDetailRepository,
                               WidgetRepository widgetRepository,
                               UserRepository userRepository) {
        this.widgetDetailRepository = widgetDetailRepository;
        this.widgetRepository = widgetRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void addWidgetDetail(String userId, Integer widgetId, String content) {
        Widget widget = widgetRepository.findById(widgetId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 widget_id입니다."));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 user_id입니다."));

        WidgetDetail detail = new WidgetDetail();
        detail.setUser(user);
        detail.setWidget(widget);
        detail.setWidgetContent(content);
        detail.setWidgetOrder(0);  // 기본 순서

        widgetDetailRepository.save(detail);
    }

    @Transactional
    public List<Map<String, Object>> getUserWidgets(String userId) {
        System.out.println("userId: " + userId);
        List<WidgetDetail> details = widgetDetailRepository.findAllByUserIdOrderByOrder(userId);
        System.out.println("조회된 위젯 수: " + details.size());

        return widgetDetailRepository.findAllByUserIdOrderByOrder(userId).stream().map(wd -> {
            Widget w = wd.getWidget();
            Map<String, Object> m = new HashMap<>();
            m.put("widget_id", w.getId());
            m.put("widget_size", w.getWidgetSize());
            m.put("widget_theme", w.getWidgetTheme());
            m.put("widget_json", w.getWidgetJson());
            m.put("widget_content", wd.getWidgetContent()); // 👈 반드시 추가
            return m;
        }).collect(Collectors.toList());
    }

    @Transactional
    public void deleteWidget(String userId, Integer widgetId) {
        widgetDetailRepository.deleteByUserIdAndWidgetId(userId, widgetId);
    }

    @Transactional
    public void updateWidgetOrder(List<Map<String, Object>> orders) {
        orders.forEach(entry -> {
            String userId = (String) entry.get("user_id");
            Integer widgetId = (Integer) entry.get("widget_id");
            Integer order = (Integer) entry.get("order");

            WidgetDetailId id = new WidgetDetailId(userId, widgetId);
            widgetDetailRepository.findById(id).ifPresent(wd -> {
                wd.setWidgetOrder(order);
                widgetDetailRepository.save(wd);
            });
        });
    }
}


