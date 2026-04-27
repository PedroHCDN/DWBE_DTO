package com.aulas.dwbe_dto.repository;

import com.aulas.dwbe_dto.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository <Prontuario, Long> {
}
