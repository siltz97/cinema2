package com.example.cinema2.sheduling;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@Service
public class DynamicSchedulerService {
    private final TaskScheduler scheduler;

    public DynamicSchedulerService(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public ScheduledFuture<?> scheduleAt(Runnable task, Instant instant) {
        return scheduler.schedule(task, Date.from(instant));
    }

    public ScheduledFuture<?> scheduleWithCron (Runnable task, CronTrigger cronTrigger) {
        return scheduler.schedule(task, cronTrigger);
    }
}
