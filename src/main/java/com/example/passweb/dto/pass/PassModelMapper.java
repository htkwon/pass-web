package com.example.passweb.dto.pass;

import com.example.passweb.entity.pass.PassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassModelMapper {

    PassModelMapper INSTANCE = Mappers.getMapper(PassModelMapper.class);

    @Mapping(target="packageName",source = "packageEntity.packageName")
    PassDto map(PassEntity passEntity);

    List<PassDto> map(List<PassEntity> passEntities);



}
