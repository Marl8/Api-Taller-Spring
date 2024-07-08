package com.taller.repository;

import com.taller.entity.MecRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecRepRepository extends JpaRepository<MecRep, Long> {
}
