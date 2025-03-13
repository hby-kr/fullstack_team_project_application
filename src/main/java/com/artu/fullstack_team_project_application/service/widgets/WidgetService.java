package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.users.User;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    private final WidgetRepository widgetRepository;
    private final WidgetDetailService widgetDetailService; // WidgetDetailService 사용

    @Autowired
    public WidgetService(WidgetRepository widgetRepository, WidgetDetailService widgetDetailService) {
        this.widgetRepository = widgetRepository;
        this.widgetDetailService = widgetDetailService;
    }

    public List<Map<String, Object>> getAllWidgetsWithDetails() {
        List<Widget> widgets = widgetRepository.findAll();
        List<Map<String, Object>> results = new ArrayList<>();

        for (Widget widget : widgets) {
            Map<String, Object> widgetMap = new HashMap<>();
            widgetMap.put("widget_id", widget.getId());
            widgetMap.put("user_id", widget.getUser().getUserId());
            widgetMap.put("widget_size", widget.getWidgetSize());
            widgetMap.put("widget_is_used", widget.getWidgetIsUsed());
            widgetMap.put("widget_theme", widget.getWidgetTheme());

            // WidgetDetailService 호출
            Map<String, Object> details = widgetDetailService.getDetailsForWidget(widget.getId());
            widgetMap.putAll(details);

            results.add(widgetMap);
        }
        return results;
    }

    // 위젯 새로 생성
    public Widget createWidget(Integer id, User user, Integer widgetSize, String widgetTheme) {
        Widget widget = new Widget();
        widget.setId(id);
        widget.setUser(user);
        widget.setWidgetSize(widgetSize);
        widget.setWidgetTheme(widgetTheme);
        widget.setWidgetIsUsed(false); // 기본값 설정
        return widgetRepository.save(widget); // 저장 후 반환
    }

    // 위젯 삭제
    public void deleteWidgetById(Integer id) {
        if (!widgetRepository.existsById(id)) {
            throw new IllegalArgumentException("Widget with the given ID does not exist");
        }
        widgetRepository.deleteById(id);
    }

    // 특정 widgetId로 위젯을 찾아 반환
    public Widget findWidgetById(Integer widgetId) {
        Optional<Widget> widget = widgetRepository.findById(widgetId);
        return widget.orElseThrow(() -> new IllegalArgumentException("Widget not found"));
    }

    // 특정 userId와 관련된 widgetIsUsed 가 TRUE 인 모든 위젯 반환
    public List<Widget> findWidgetsByUserIdAndUsed(String userId) {
        return widgetRepository.findWidgetsByUserIdAndWidgetIsUsedTrue(userId);
    }

    // 특정 widgetId와 userId로 widgetIsUsed 를 TRUE 로 설정
    public boolean setWidgetUsedTrue(Integer widgetId, String userId) {
        int updatedRows = widgetRepository.updateWidgetIsUsedToTrue(widgetId, userId);
        return updatedRows > 0; // 성공적으로 업데이트된 행이 1개 이상이면 true 반환
    }

    // 특정 widgetId와 userId로 widgetIsUsed 를 FALSE 로 설정
    public boolean setWidgetUsedFalse(Integer widgetId, String userId) {
        int updatedRows = widgetRepository.updateWidgetIsUsedToFalse(widgetId, userId);
        return updatedRows > 0; // 성공적으로 업데이트된 행이 1개 이상이면 true 반환
    }

    // 특정 widgetTheme 과 동일한 값을 포함하는 모든 widgetId 반환
    public List<Integer> getWidgetIdsByTheme(String widgetTheme) {
        return widgetRepository.findWidgetIdsByWidgetTheme(widgetTheme);
    }

    // 특정 userId와 관련된 widgetTheme 값을 모두 반환
    public String findWidgetThemeByWidgetIdAndUserId(Integer widgetId, String userId) {
        String widgetTheme = widgetRepository.findWidgetThemeByWidgetIdAndUserId(widgetId, userId);
        if (widgetTheme == null) {
            throw new IllegalArgumentException("Widget not found with the given widgetId and userId");
        }
        return widgetTheme;
    }

    // 특정 userId와 관련된 widgetSize 값을 모두 반환
    public Integer findWidgetSizeByWidgetIdAndUserId(Integer widgetId, String userId) {
        Integer widgetSize = widgetRepository.findWidgetSizeByWidgetIdAndUserId(widgetId, userId);
        if (widgetSize == null) {
            throw new IllegalArgumentException("Widget not found with the given widgetId and userId");
        }
        return widgetSize;
    }

    // 특정 userId와 widgetSize 로 관련된 widgetId 값을 모두 반환
    public Integer findWidgetIdByWidgetSizeAndUserId(Integer widgetSize, String userId) {
        return widgetRepository.findWidgetIdByWidgetSizeAndUserId(widgetSize, userId);
    }
}