package com.taller.repository;

import com.taller.entity.ComposeKey.FichaMdKey;
import com.taller.entity.FichaMd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaMdRepository extends JpaRepository<FichaMd, FichaMdKey> {
}
