package com.kesavan.springbatchexp.step;

import com.kesavan.springbatchexp.model.InputDataSource;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@StepScope
public class DataSummarizerReader implements ItemReader<InputDataSource> {


    @Override
    @SuppressWarnings("deprecation")
    public InputDataSource read() {

        // TODO: Write the logic to read a CSV file and put the contents into InputDataSource Object
        Date date = new Date();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();

        if(minutes % 3 != 0) {
            System.out.println("Non 3rd minute.  Wait some more time. " + date);
            return null;
        } else if(seconds % 10 != 0) {
            System.out.println("Non 10th second.  Wait some more time. " + date);
            return null;
        }

        List<Integer> inputData = Arrays.asList(100, 200, 300);

        System.out.println("\n \n \nInput CSV file is read "+ date);

        return InputDataSource.builder()
                .inputData(inputData)
                .build();
    }
}
