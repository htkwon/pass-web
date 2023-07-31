package com.example.passweb.dto.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AggregatedStatisticsDto {

    private LocalDateTime statisticsAt;
    private Long allCount;
    private Long attendedCount;
    private Long cancelledCount;

    public void merge(AggregatedStatisticsDto statistics){
        this.allCount += statistics.getAllCount();
        this.attendedCount += statistics.getAttendedCount();
        this.cancelledCount += statistics.getCancelledCount();
    }



}
