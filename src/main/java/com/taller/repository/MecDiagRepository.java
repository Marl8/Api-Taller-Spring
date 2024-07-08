package com.taller.repository;

import com.taller.entity.MecDiag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecDiagRepository extends JpaRepository<MecDiag, Long> {
}
