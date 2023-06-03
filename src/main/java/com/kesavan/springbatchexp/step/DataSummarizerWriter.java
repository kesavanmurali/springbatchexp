package com.kesavan.springbatchexp.step;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@StepScope
public class DataSummarizerWriter implements ItemWriter<Integer> {


    @Override
    public void write(List<? extends Integer> items) {
        items.forEach(item -> System.out.println("Data summarization Output "+item));
    }
}
