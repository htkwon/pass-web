package com.example.passweb.entity.user;

import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserGroupMappingId implements Serializable {
    private String userGroupId;
    private String userId;

}
