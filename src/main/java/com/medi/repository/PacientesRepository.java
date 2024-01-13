package com.medi.repository;

import com.medi.entity.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<Pacientes, Long> {

}
