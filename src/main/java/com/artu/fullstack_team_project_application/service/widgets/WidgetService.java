package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    private final WidgetRepository widgetRepository;

    @Autowired
    public WidgetService(WidgetRepository widgetRepository) {
        this.widgetRepository = widgetRepository;
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

}