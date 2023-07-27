package com.example.passweb.dto.statistics;

import lombok.Data;

import java.util.List;

@Data
public class ChartDataDto {

    private List<String> labels;
    private List<Integer> attendedCount;
    private List<Integer> cancelledCount;

    public ChartDataDto(List<String> labels, List<Integer> attendedCount, List<Integer> cancelledCount){
        this.labels = labels;
        this.attendedCount = attendedCount;
        this.cancelledCount = cancelledCount;
    }
}
