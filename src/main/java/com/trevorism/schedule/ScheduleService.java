package com.trevorism.schedule;

import com.trevorism.schedule.model.ScheduledTask;

import java.util.List;

public interface ScheduleService {

    ScheduledTask create(ScheduledTask schedule);
    ScheduledTask update(ScheduledTask scheduledTask);
    ScheduledTask get(String id);
    List<ScheduledTask> list();
    ScheduledTask delete(String id);
}
