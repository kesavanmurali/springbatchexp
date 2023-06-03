package com.kesavan.springbatchexp.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataSummarizerJobScheduler {

    private final JobLauncher jobLauncher;

    private final Job dataSummarizationJob;


    @Scheduled(fixedDelay = 1000)
    public void launchJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        System.out.println("Scheduler runs now : "+System.currentTimeMillis());
        JobParameters parameters = new JobParametersBuilder()
                .addString("jobId", UUID.randomUUID().toString())
                .addString("jobName", "dataSummarizationJob")
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(dataSummarizationJob, parameters);
    }
}
