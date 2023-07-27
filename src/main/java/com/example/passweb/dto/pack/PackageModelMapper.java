package com.example.passweb.dto.pack;

import com.example.passweb.entity.pack.PackageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PackageModelMapper {

    PackageModelMapper INSTANCE = Mappers.getMapper(PackageModelMapper.class);

    List<PackageDto> map(List<PackageEntity> packageEntities);


}
