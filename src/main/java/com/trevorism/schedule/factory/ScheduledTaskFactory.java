package com.trevorism.schedule.factory;

import com.trevorism.schedule.model.ScheduledTask;

import java.util.Date;

public interface ScheduledTaskFactory {

    ScheduledTask createImmediateTask(String name, Date startDate, EndpointSpec spec);
    ScheduledTask createHourlyTask(String name, Date startDate, EndpointSpec spec);
    ScheduledTask createDailyTask(String name, Date startDate, EndpointSpec spec);

    ScheduledTask createImmediateTask(String name, Date startDate, EndpointSpec spec, boolean enabled);
    ScheduledTask createHourlyTask(String name, Date startDate, EndpointSpec spec, boolean enabled);
    ScheduledTask createDailyTask(String name, Date startDate, EndpointSpec spec, boolean enabled);
}
