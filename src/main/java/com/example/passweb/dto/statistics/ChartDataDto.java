package com.example.passweb.dto.statistics;

import lombok.Getter;

import java.util.List;

@Getter
public class ChartDataDto {

    private List<String> labels;
    private List<Long> attendedCount;
    private List<Long> cancelledCount;

    public ChartDataDto(List<String> labels, List<Long> attendedCount, List<Long> cancelledCount){
        this.labels = labels;
        this.attendedCount = attendedCount;
        this.cancelledCount = cancelledCount;
    }
}
