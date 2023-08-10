package com.example.passweb.service.statistics;

import com.example.passweb.dto.statistics.AggregatedStatisticsDto;
import com.example.passweb.dto.statistics.ChartDataDto;
import com.example.passweb.repository.StatisticsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StatisticsServiceTest {


    @Mock
    private StatisticsRepository statisticsRepository;

    @InjectMocks
    private StatisticsService statisticsService;


    /**
     * Junit5 에만 있는 기능으로 TEST
     * 계층적 Test 가능
     */
    @Nested
    @DisplayName("통계 데이터로 차트 만들기")
    class makeChartDate {
        final LocalDateTime to = LocalDateTime.of(2023,8,4,0,0);

        @DisplayName("통계 데이터가 있을 때")
        @Test
        void makeChartData_when_hasStatistics(){
            //given
            final LocalDateTime to = LocalDateTime.of(2023,8,4,0,0);

            List<AggregatedStatisticsDto> statisticsDtoList = List.of(
                    new AggregatedStatisticsDto(to.minusDays(1), 15L,10L,5L),
                    new AggregatedStatisticsDto(to, 10L,8L,2L)
            );

            //when
            when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)),eq(to))).thenReturn(statisticsDtoList);
            final ChartDataDto chartDataDto = statisticsService.makeChatData(to);


            //then
            verify(statisticsRepository,times(1)).findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)),eq(to));

            assertNotNull(chartDataDto);
            assertEquals(new ArrayList<>(List.of("08-03","08-04")),chartDataDto.getLabels());
            assertEquals(new ArrayList<>(List.of(10L,8L)),chartDataDto.getAttendedCount());
            assertEquals(new ArrayList<>(List.of(5L,2L)),chartDataDto.getCancelledCount());
        }

        @DisplayName("통계 데이터가 없을 때")
        @Test
        void makeChartData_when_notStatistics(){
            //given


            //when
            when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)),eq(to))).thenReturn(Collections.emptyList());
            final ChartDataDto chartDataDto = statisticsService.makeChatData(to);


            //then
            verify(statisticsRepository,times(1)).findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)),eq(to));

            assertNotNull(chartDataDto);

            assertTrue(chartDataDto.getLabels().isEmpty());
            assertTrue(chartDataDto.getAttendedCount().isEmpty());
            assertTrue(chartDataDto.getCancelledCount().isEmpty());

        }




    }

    /**
     * 일반 TEST 위와 동일 기능
     */
    @Test
    public void test_makeChartData(){
        //given
        final LocalDateTime to = LocalDateTime.of(2023,8,4,0,0);

        List<AggregatedStatisticsDto> statisticsDtoList = List.of(
                new AggregatedStatisticsDto(to.minusDays(1), 15L,10L,5L),
                new AggregatedStatisticsDto(to, 10L,8L,2L)
        );

        //when
        when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)),eq(to))).thenReturn(statisticsDtoList);
        final ChartDataDto chartDataDto = statisticsService.makeChatData(to);


        //then
        verify(statisticsRepository,times(1)).findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)),eq(to));

        assertNotNull(chartDataDto);
        assertEquals(new ArrayList<>(List.of("08-03","08-04")),chartDataDto.getLabels());
        assertEquals(new ArrayList<>(List.of(10L,8L)),chartDataDto.getAttendedCount());
        assertEquals(new ArrayList<>(List.of(5L,2L)),chartDataDto.getCancelledCount());
    }








}
