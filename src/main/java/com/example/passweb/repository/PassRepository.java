package com.example.passweb.repository;

import com.example.passweb.entity.pass.PassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassRepository extends JpaRepository<PassEntity,Long> {
    List<PassEntity> findByUserId(String userId);
}
