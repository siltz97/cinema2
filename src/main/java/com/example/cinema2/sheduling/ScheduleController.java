package com.example.cinema2.sheduling;

import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;


@RestController
public class ScheduleController {

    private final DynamicSchedulerService dynamicSchedulerService;
    private final Map<String, ScheduledFuture<?>> jobs = new HashMap<>();

    public ScheduleController(DynamicSchedulerService dynamicSchedulerService) {
        this.dynamicSchedulerService = dynamicSchedulerService;
    }

    //   @PreAuthorize("hasRole('USER')")
    @GetMapping("/schedule")
    public String scheduleJob(@RequestParam String name, @RequestParam String cron) {
        Runnable task = () -> System.out.println("esecuzione " + name + " alle " + LocalTime.now());
        CronTrigger cronTrigger = new CronTrigger(cron, ZoneId.of("Europe/Rome"));
        ScheduledFuture<?> future = dynamicSchedulerService.scheduleWithCron(task, cronTrigger);
        jobs.put(name, future);
        return "Job " + name + " scheduled with cron " + cron;
    }

    //  @PreAuthorize("hasRole('USER')")
    @GetMapping("/cancel")
    public String cancelJob(@RequestParam String name) {
        ScheduledFuture<?> future = jobs.remove(name);
        if (future != null) {
            future.cancel(true);
            return "Job " + name + " cancelled";
        }
        return "Job " + name + " non trovato";
    }
}
