package com.trevorism.schedule;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.trevorism.https.DefaultSecureHttpClient;
import com.trevorism.https.SecureHttpClient;
import com.trevorism.schedule.model.ScheduledTask;

import java.lang.reflect.Type;
import java.util.List;

public class DefaultScheduleService implements ScheduleService {

    private SecureHttpClient secureHttpClient = new DefaultSecureHttpClient();
    private static final String SCHEDULER_BASE_URL = "https://schedule.action.trevorism.com/api/schedule";

    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();

    @Override
    public ScheduledTask create(ScheduledTask schedule) {
        String scheduleJson = gson.toJson(schedule);
        String json = secureHttpClient.post(SCHEDULER_BASE_URL, scheduleJson);
        ScheduledTask task = gson.fromJson(json, ScheduledTask.class);
        return task;
    }

    @Override
    public ScheduledTask getByName(String name) {
        try {
            String json = secureHttpClient.get(SCHEDULER_BASE_URL + "/" + name.toLowerCase());
            ScheduledTask task = gson.fromJson(json, ScheduledTask.class);
            return task;
        } catch (Exception ignored) {
            return ScheduledTask.NULL_SCHEDULED_TASK;
        }
    }

    @Override
    public ScheduledTask update(ScheduledTask scheduledTask) {
        try {
            String scheduleJson = gson.toJson(scheduledTask);
            String json = secureHttpClient.put(SCHEDULER_BASE_URL + "/" + scheduledTask.getName().toLowerCase(), scheduleJson);
            ScheduledTask task = gson.fromJson(json, ScheduledTask.class);
            return task;
        } catch (Exception ignored) {
            return ScheduledTask.NULL_SCHEDULED_TASK;
        }
    }

    @Override
    public List<ScheduledTask> list() {
        String json = secureHttpClient.get(SCHEDULER_BASE_URL);
        Type listType = TypeToken.getParameterized(List.class, ScheduledTask.class).getType();
        return gson.fromJson(json, listType);
    }

    @Override
    public boolean delete(String name) {
        String json = secureHttpClient.delete(SCHEDULER_BASE_URL + "/" + name.toLowerCase());
        return Boolean.parseBoolean(json);
    }
}
