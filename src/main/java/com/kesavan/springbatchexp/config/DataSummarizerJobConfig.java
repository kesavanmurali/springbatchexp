package com.kesavan.springbatchexp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kesavan.springbatchexp.model.InputDataSource;

@Configuration
@RequiredArgsConstructor
public class DataSummarizerJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final ItemReader<InputDataSource> dataSummarizerReader;

    private final ItemProcessor<InputDataSource, Integer> dataSummarizerProcessor;

    private final ItemWriter<Integer> dataSummarizerWriter;

    @Bean
    public Step dataSummarizationStep(){
        return stepBuilderFactory.get("dataSummarizationStep")
                .<InputDataSource, Integer>chunk(1)
                .reader(dataSummarizerReader)
                .processor(dataSummarizerProcessor)
                .writer(dataSummarizerWriter)
                .build();
    }

    @Bean
    public Job dataSummarizationJob(Step dataSummarizationStep){
        return jobBuilderFactory.get("dataSummarizationJob")
                .flow(dataSummarizationStep)
                .end()
                .build();
    }
}
