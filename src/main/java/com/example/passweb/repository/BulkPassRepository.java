package com.example.passweb.repository;

import com.example.passweb.entity.pass.BulkPassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulkPassRepository extends JpaRepository<BulkPassEntity,Long> {
    List<BulkPassEntity> findAllOrderByStartedAtDesc();
}
