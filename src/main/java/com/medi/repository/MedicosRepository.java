package com.medi.repository;

import com.medi.entity.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicosRepository extends JpaRepository<Medicos, Long> {

}
