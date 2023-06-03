package com.kesavan.springbatchexp.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataSummarizerJobScheduler {

    @Scheduled(fixedRate = 1000)
    public void launchJob() {
        System.out.println("Scheduler runs now : "+System.currentTimeMillis());
    }
}
