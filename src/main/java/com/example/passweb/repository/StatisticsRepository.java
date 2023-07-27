package com.example.passweb.repository;

import com.example.passweb.dto.statistics.AggregatedStatisticsDto;
import com.example.passweb.entity.statistics.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticsRepository extends JpaRepository<StatisticsEntity,Long> {



    @Query(value = "SELECT new com.example.passweb.dto.statistics.AggregatedStatisticsDto(s.statisticsAt,SUM(s.allCount),SUM(a.attendedCount),SUM(s.cancelledCount)) " +
                    "FROM StatisticsEntity  s "+
                    "WHERE s.statisticsAt BETWEEN :from AND :to "+
                    "GROUP BY s.statisticsAt")
    List<AggregatedStatisticsDto> findByStatisticsAtBetweenAndGroupBy(@Param("from")LocalDateTime from, @Param("to") LocalDateTime to);


}
