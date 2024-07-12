package com.taller.repository;

import com.taller.entity.ComposeKey.PresurepKey;
import com.taller.entity.PresuRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresuRepRepository extends JpaRepository<PresuRep, PresurepKey> {

}
