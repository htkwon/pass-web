package com.example.passweb.service.user;

import com.example.passweb.dto.user.UserDto;
import com.example.passweb.dto.user.UserModelMapper;
import com.example.passweb.entity.user.UserEntity;
import com.example.passweb.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserDto getUser(String userId){
        UserEntity entity = userRepository.findById(userId)
                .orElse(null);
        return UserModelMapper.INSTANCE.toUSer(entity);
    }


}
