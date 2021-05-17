package com.trevorism.schedule.factory;

import com.trevorism.schedule.model.ScheduledTask;
import com.trevorism.schedule.model.ScheduledTaskType;

import java.util.Date;

public class DefaultScheduledTaskFactory implements ScheduledTaskFactory {
    @Override
    public ScheduledTask createImmediateTask(String name, Date startDate, EndpointSpec spec) {
        return createImmediateTask(name, startDate, spec, true);
    }

    @Override
    public ScheduledTask createHourlyTask(String name, Date startDate, EndpointSpec spec) {
        return createHourlyTask(name, startDate, spec, true);
    }

    @Override
    public ScheduledTask createDailyTask(String name, Date startDate, EndpointSpec spec) {
        return createDailyTask(name, startDate, spec, true);
    }

    @Override
    public ScheduledTask createImmediateTask(String name, Date startDate, EndpointSpec spec, boolean enabled) {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setType(ScheduledTaskType.IMMEDIATE.toString().toLowerCase());
        setCommonProperties(name, startDate, spec, enabled, scheduledTask);
        return scheduledTask;
    }

    @Override
    public ScheduledTask createHourlyTask(String name, Date startDate, EndpointSpec spec, boolean enabled) {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setType(ScheduledTaskType.HOURLY.toString().toLowerCase());
        setCommonProperties(name, startDate, spec, enabled, scheduledTask);
        return scheduledTask;
    }

    @Override
    public ScheduledTask createDailyTask(String name, Date startDate, EndpointSpec spec, boolean enabled) {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setType(ScheduledTaskType.DAILY.toString().toLowerCase());
        setCommonProperties(name, startDate, spec, enabled, scheduledTask);
        return scheduledTask;
    }

    private void setCommonProperties(String name, Date startDate, EndpointSpec spec, boolean enabled, ScheduledTask scheduledTask) {
        scheduledTask.setName(name);
        scheduledTask.setStartDate(startDate);
        scheduledTask.setEnabled(enabled);
        scheduledTask.setEndpoint(spec.getEndpoint());
        scheduledTask.setHttpMethod(spec.getHttpMethod());
        scheduledTask.setRequestJson(spec.getRequestJson());
    }
}
