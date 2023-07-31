package com.example.passweb.service.user;

import com.example.passweb.repository.UserGroupMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGroupMappingService {

    private final UserGroupMappingRepository userGroupMappingRepository;

    public List<String> getAllUserGroupIds(){
        return userGroupMappingRepository.findDistinctUserGroupId();
    }


}
