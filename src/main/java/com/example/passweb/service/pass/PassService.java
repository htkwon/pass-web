package com.example.passweb.service.pass;

import com.example.passweb.dto.pass.PassDto;
import com.example.passweb.dto.pass.PassModelMapper;
import com.example.passweb.entity.pass.PassEntity;
import com.example.passweb.repository.PassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassService {

    private final PassRepository passRepository;



    public List<PassDto> getPasses(String userId){
        List<PassEntity> passEntities = passRepository.findByUserId(userId);
        return PassModelMapper.INSTANCE.map(passEntities);
    }



}
