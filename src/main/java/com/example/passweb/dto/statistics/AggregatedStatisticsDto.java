package com.example.passweb.dto.statistics;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AggregatedStatisticsDto {

    private LocalDateTime statisticsAt;
    private int allCount;
    private int attendedCount;
    private int cancelledCount;

    public void merge(AggregatedStatisticsDto statistics){
        this.allCount += statistics.getAllCount();
        this.attendedCount += statistics.getAttendedCount();
        this.cancelledCount += statistics.getCancelledCount();
    }



}
