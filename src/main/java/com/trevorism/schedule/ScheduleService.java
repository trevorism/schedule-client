package com.trevorism.schedule;

import com.trevorism.schedule.model.ScheduledTask;

import java.util.List;

public interface ScheduleService {

    ScheduledTask create(ScheduledTask schedule);
    ScheduledTask update(ScheduledTask scheduledTask);
    ScheduledTask getByName(String name);
    List<ScheduledTask> list();
    boolean delete(String name);
}
