package com.example.passweb.repository;

import com.example.passweb.entity.user.UserGroupMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupMappingRepository extends JpaRepository<UserGroupMappingEntity,String> {

    @Query("select distinct u.userGroupId " +
            "from UserGroupMappingEntity u "+
            "order by u.userGroupId"
    )
    List<String> findDistinctUserGroupId();
}
