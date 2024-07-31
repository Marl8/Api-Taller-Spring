package com.taller.repository;

import com.taller.entity.PermissionEntity;
import com.taller.entity.enums.PermissionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    Optional<PermissionEntity> findByPermission(PermissionEnum name);
}
