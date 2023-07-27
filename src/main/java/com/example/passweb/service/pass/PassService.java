package com.example.passweb.service.pass;

import com.example.passweb.dto.pass.PassDto;
import com.example.passweb.dto.pass.PassModelMapper;
import com.example.passweb.entity.pass.PassEntity;
import com.example.passweb.repository.PassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassService {

    private PassRepository passRepository;

    public List<PassDto> getPasses(String userId){
        List<PassEntity> passEntities = passRepository.findByUserId(userId);
        return PassModelMapper.INSTANCE.map(passEntities);
    }



}
