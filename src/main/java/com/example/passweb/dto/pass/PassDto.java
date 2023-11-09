package com.example.passweb.dto.pass;

import com.example.passweb.status.PassStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PassDto {
    private Long passSeq;
    private Long packageSeq;
    private String packageName;
    private String userId;

    private PassStatus status;
    private int remainingCount;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime expiredAt;



}
