package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetailId;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetDetailRepository;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    private final WidgetRepository widgetRepository;
    private final WidgetDetailRepository widgetDetailRepository;

    public WidgetService(WidgetRepository widgetRepository, WidgetDetailRepository widgetDetailRepository) {
        this.widgetRepository = widgetRepository;
        this.widgetDetailRepository = widgetDetailRepository;
    }

    public List<Widget> getAllWidgets() {
        return widgetRepository.findAll();
    }

    public Optional<Widget> getWidgetById(Integer id) {
        return widgetRepository.findById(id);
    }

    public Widget saveWidget(Widget widget) {
        return widgetRepository.save(widget);
    }

    public void deleteWidget(Integer id) {
        widgetRepository.deleteById(id);
    }

    public List<WidgetDetail> getAllWidgetDetails() {
        return widgetDetailRepository.findAll();
    }

    public Optional<WidgetDetail> getWidgetDetailById(WidgetDetailId id) {
        return widgetDetailRepository.findById(id);
    }

    public WidgetDetail saveWidgetDetail(WidgetDetail widgetDetail) {
        return widgetDetailRepository.save(widgetDetail);
    }

    public void deleteWidgetDetail(WidgetDetailId id) {
        widgetDetailRepository.deleteById(id);
    }
}
