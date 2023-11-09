package com.example.passweb.entity.user;

import com.example.passweb.entity.BaseEntity;
import com.example.passweb.status.UserStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Id
    private String userId;

    private String userName;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String phone;

    //    private String meta;
    private String uuid;

    public void setUuid(String uuid){this.uuid = uuid;}

}
