package com.trevorism.schedule

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.trevorism.https.SecureHttpClient
import com.trevorism.schedule.factory.DefaultScheduledTaskFactory
import com.trevorism.schedule.factory.EndpointSpec
import com.trevorism.schedule.factory.ScheduledTaskFactory
import com.trevorism.schedule.model.HttpMethod
import com.trevorism.schedule.model.ScheduledTask
import org.junit.Before
import org.junit.Test

import java.time.Instant

class DefaultScheduleServiceTest {

    ScheduleService service = new DefaultScheduleService()

    @Before
    void setup() {
        final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();

        service.secureHttpClient = [get   : { String url -> return sampleGetResponse(url, gson) },
                                    post  : { String url, def schedule -> gson.toJson(createSampleScheduledTask()) },
                                    put   : { String url, def schedule -> gson.toJson(createSampleScheduledTask()) },
                                    delete: { String url -> return "true" }
        ] as SecureHttpClient
    }

    private Serializable sampleGetResponse(String url, Gson gson) {
        if (url.toLowerCase().endsWith("testsched")) {
            return gson.toJson(createSampleScheduledTask())
        }
        return gson.toJson([createSampleScheduledTask()])
    }

    @Test
    void testCreate() {
        ScheduledTask st = createSampleScheduledTask()
        assert service.create(st)
    }

    private ScheduledTask createSampleScheduledTask() {
        ScheduledTaskFactory factory = new DefaultScheduledTaskFactory()
        EndpointSpec endpointSpec = new EndpointSpec("https://testing.trevorism.com/api/ping", HttpMethod.GET, null)
        return factory.createImmediateTask("testSched", Instant.now().plus(60 * 60 * 3).toDate(), endpointSpec, true)
    }

    @Test
    void testGetByName() {
        assert service.getByName("testSched")
    }

    @Test
    void testUpdate() {
        ScheduledTaskFactory factory = new DefaultScheduledTaskFactory()
        EndpointSpec endpointSpec = new EndpointSpec("https://testing.trevorism.com/api/ping", HttpMethod.GET, "")
        ScheduledTask st = factory.createImmediateTask("testsched", new Date(), endpointSpec, true)
        assert service.update(st)
    }

    @Test
    void testList() {
        assert service.list()
    }

    @Test
    void testDelete() {
        assert service.delete("testSched")
    }
}
