package com.example.passweb.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class UserGroupMappingId implements Serializable {
    private String userGroupId;
    private String userId;

}
