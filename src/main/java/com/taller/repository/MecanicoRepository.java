package com.taller.repository;

import com.taller.entity.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

    Optional<Mecanico> findMecanicoByDni(String dni);
}
