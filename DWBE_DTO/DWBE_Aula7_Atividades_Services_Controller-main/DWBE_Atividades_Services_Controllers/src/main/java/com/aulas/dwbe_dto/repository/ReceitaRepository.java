package com.aulas.dwbe_dto.repository;

import com.aulas.dwbe_dto.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
