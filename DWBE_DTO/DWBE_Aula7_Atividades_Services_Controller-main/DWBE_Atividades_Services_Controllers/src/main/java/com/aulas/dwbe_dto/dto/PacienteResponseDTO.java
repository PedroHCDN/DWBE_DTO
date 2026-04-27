package com.aulas.dwbe_dto.dto;

import com.aulas.dwbe_dto.model.Consulta;
import com.aulas.dwbe_dto.model.Prontuario;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Prontuario prontuario;
    private List<Consulta> consultas;
}
