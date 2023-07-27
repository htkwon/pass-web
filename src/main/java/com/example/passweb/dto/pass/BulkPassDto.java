package com.example.passweb.dto.pass;

import com.example.passweb.status.BulkPassStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BulkPassDto {
    private Long bulkPassSeq;
    private String userGroupId;
    private Integer count;
    private BulkPassStatus status;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;



}
