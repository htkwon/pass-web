package com.example.passweb.entity.statistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "statistics")
public class StatisticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statisticsSeq;

    private LocalDateTime statisticsAt;

    private int allCount;
    private int attendedCount;
    private int cancelledCount;



}
