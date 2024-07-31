package com.taller.repository;

import com.taller.entity.PermissionEntity;
import com.taller.entity.RoleEntity;
import com.taller.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByRoleEnum(RoleEnum name);
}
