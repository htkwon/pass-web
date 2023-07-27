package com.example.passweb.entity.pass;

import com.example.passweb.status.BulkPassStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "bulk_pass")
public class BulkPassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bulkPassSeq;

    private Long packageSeq;
    private String userGroupId;

    @Enumerated(EnumType.STRING)
    private BulkPassStatus bulkPassStatus;

    private Integer count;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    public void setEndedAt(Integer period){
        if(period == null){
            return;
        }
        this.endedAt = this.startedAt.plusDays(period);
    }

    public void setEndedAt(LocalDateTime endedAt){
        this.endedAt = endedAt;
    }


}
