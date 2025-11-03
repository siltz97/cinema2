package com.example.cinema2.sheduling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class SchedulerConfig {

    @Bean
    public ThreadPoolTaskScheduler scheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);//max thread paralleli
        scheduler.setThreadNamePrefix("MYscheduler-"); //name of the scheduler
        scheduler.setAwaitTerminationSeconds(5); // time after termination in seconds
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
}
