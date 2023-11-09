package com.example.passweb.entity.user;

import com.example.passweb.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_group_mapping")
@IdClass(UserGroupMappingId.class) //복합키를 가질 경우의 설정.
public class UserGroupMappingEntity extends BaseEntity {

    @Id
    private String userGroupId;

    @Id
    private String userId;

    private String userGroupName;
    private String description;


}
