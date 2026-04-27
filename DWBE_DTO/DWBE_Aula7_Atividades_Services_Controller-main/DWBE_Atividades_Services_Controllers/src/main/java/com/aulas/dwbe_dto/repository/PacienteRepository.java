package com.aulas.dwbe_dto.repository;

import com.aulas.dwbe_dto.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
