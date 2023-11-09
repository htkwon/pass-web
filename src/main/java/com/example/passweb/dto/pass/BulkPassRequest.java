package com.example.passweb.dto.pass;

import com.example.passweb.util.LocalDateTimeUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BulkPassRequest {
    private Long packageSeq;
    private String userGroupId;
    private LocalDateTime startedAt;

    public void setStartedAt(String startedAtString){
        this.startedAt = LocalDateTimeUtils.parse(startedAtString);
    }



}
