package com.example.passweb.entity.pass;


import com.example.passweb.entity.BaseEntity;
import com.example.passweb.entity.pack.PackageEntity;
import com.example.passweb.status.PassStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pass")
public class PassEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passSeq;
    private Long packageSeq;

    private String userId;

    @Enumerated(EnumType.STRING)
    private PassStatus status;

    private int remainingCount;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    private LocalDateTime expiredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packageSeq", insertable = false, updatable = false)
    private PackageEntity packageEntity;


}
