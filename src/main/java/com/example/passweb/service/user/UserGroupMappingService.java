package com.example.passweb.service.user;

import com.example.passweb.repository.UserGroupMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupMappingService {

    private UserGroupMappingRepository userGroupMappingRepository;

    public List<String> getAllUserGroupIds(){
        return userGroupMappingRepository.findDistinctUserGroupId();
    }


}
