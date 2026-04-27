package com.aulas.dwbe_dto.dto;

import com.aulas.dwbe_dto.model.Consulta;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String especialidade;
    private String crm;
    private List<Consulta> consultas;
}
