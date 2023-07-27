package com.example.passweb.repository;

import com.example.passweb.entity.pack.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<PackageEntity,Long> {
    List<PackageEntity> findAllByOrderByPackageName();
}
