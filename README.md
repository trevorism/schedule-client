# eventhub-client
![Jenkins](https://img.shields.io/jenkins/build/http/trevorism-build.eastus.cloudapp.azure.com/schedule-client)
![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco/http/trevorism-build.eastus.cloudapp.azure.com/schedule-client)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/schedule-client)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/schedule-client)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/schedule-client)


Java client for Trevorism scheduling API: [Trevorism Schedule](https://github.com/trevorism/schedule)

Current version: 0.3.1

## How to Use 
```
        ScheduledTaskFactory factory = new DefaultScheduledTaskFactory()
        EndpointSpec endpointSpec = new EndpointSpec("https://testing.trevorism.com/api/ping", HttpMethod.GET, null)
        ScheduledTask st = factory.createImmediateTask("testSched", Instant.now().plus(60 * 60 * 3).toDate(), endpointSpec)
        ScheduleService service = new DefaultScheduleService()
        service.create(st)
```

Note: This library assumes the library consumer has a valid credentials per https://github.com/trevorism/secure-http-utils

## How to Build
`gradle clean build`