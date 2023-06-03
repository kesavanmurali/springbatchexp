package com.kesavan.springbatchexp.step;

import com.kesavan.springbatchexp.model.InputDataSource;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class DataSummarizerProcessor implements ItemProcessor<InputDataSource, Integer> {
    @Override
    public Integer process(InputDataSource item) {
        System.out.println("Processing the data....");
        return item.getInputData().stream().reduce(Integer::sum).orElse(-99999);
    }
}
