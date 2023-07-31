package com.example.passweb.service.statistics;


import com.example.passweb.dto.statistics.AggregatedStatisticsDto;
import com.example.passweb.dto.statistics.ChartDataDto;
import com.example.passweb.repository.StatisticsRepository;
import com.example.passweb.util.LocalDateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    public ChartDataDto makeChatData(LocalDateTime to){
        LocalDateTime from = to.minusDays(10);

        List<AggregatedStatisticsDto> aggregatedStatisticsDtoList = statisticsRepository.findByStatisticsAtBetweenAndGroupBy(from,to);

        List<String> labels = new ArrayList<>();
        List<Long> attendedCounts = new ArrayList<>();
        List<Long> cancelledCounts = new ArrayList<>();

        for(AggregatedStatisticsDto statisticsDto : aggregatedStatisticsDtoList){
            labels.add(LocalDateTimeUtils.format(statisticsDto.getStatisticsAt(),LocalDateTimeUtils.MM_DD));
            attendedCounts.add(statisticsDto.getAttendedCount());
            cancelledCounts.add(statisticsDto.getCancelledCount());
        }
        return new ChartDataDto(labels,attendedCounts,cancelledCounts);
    }





}
