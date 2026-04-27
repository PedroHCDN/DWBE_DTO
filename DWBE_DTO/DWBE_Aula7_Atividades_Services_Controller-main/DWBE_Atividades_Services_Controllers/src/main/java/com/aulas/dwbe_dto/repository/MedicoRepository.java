package com.aulas.dwbe_dto.repository;

import com.aulas.dwbe_dto.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository  extends JpaRepository<Medico, Long> {
}
