package com.example.cinema2.sheduling;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class MyScheduledTasks {

    private final ApplicationContext context;

    public MyScheduledTasks(ApplicationContext context) {
        this.context = context;
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 5000)  // 5 sec delay dal completamento della task
    public void task1() {
        System.out.println("task1");
        //SpringApplication.exit(this.context);
    }

    @Scheduled(fixedRate = 10000, initialDelay = 4000) //ogni 10 sec indipendentemente dalla durata dell'esecuzione della task
    public void task2() {
        System.out.println("task2");
    }

    @Scheduled(cron = "0 30 13 * * *", zone = "Europe/Rome")
    public void task3() {
        System.out.println("task3");
    }
}
