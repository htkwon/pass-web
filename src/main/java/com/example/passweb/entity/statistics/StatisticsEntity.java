package com.example.passweb.entity.statistics;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
