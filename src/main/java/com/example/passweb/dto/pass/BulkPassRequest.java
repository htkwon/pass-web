package com.example.passweb.dto.pass;

import com.example.passweb.util.LocalDateTimeUtils;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BulkPassRequest {
    private Long packageSeq;
    private String userGroupId;
    private LocalDateTime startedAt;

    public void setStartedAt(String startedAtString){
        this.startedAt = LocalDateTimeUtils.parse(startedAtString);
    }



}
