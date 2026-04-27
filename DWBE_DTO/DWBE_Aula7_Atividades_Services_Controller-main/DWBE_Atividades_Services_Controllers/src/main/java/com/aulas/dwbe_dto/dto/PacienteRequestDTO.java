package com.aulas.dwbe_dto.dto;

import com.aulas.dwbe_dto.model.Consulta;
import com.aulas.dwbe_dto.model.Prontuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteRequestDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private Prontuario prontuario;
    private List<Consulta> consultas;
}
