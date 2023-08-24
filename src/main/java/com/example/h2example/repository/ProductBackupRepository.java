package com.example.h2example.repository;

import com.example.h2example.entity.ProductBackupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBackupRepository extends JpaRepository<ProductBackupEntity, Long> {
}