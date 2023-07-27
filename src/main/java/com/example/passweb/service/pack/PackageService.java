package com.example.passweb.service.pack;

import com.example.passweb.dto.pack.PackageDto;
import com.example.passweb.dto.pack.PackageModelMapper;
import com.example.passweb.entity.pack.PackageEntity;
import com.example.passweb.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    private PackageRepository packageRepository;


    public List<PackageDto> getAllPackages(){
        List<PackageEntity> entities = packageRepository.findAllByOrderByPackageName();
        return PackageModelMapper.INSTANCE.map(entities);
    }




}
