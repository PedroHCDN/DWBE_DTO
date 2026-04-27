package com.aulas.dwbe_dto.dto;

import com.aulas.dwbe_dto.model.Consulta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConvenioRequestDTO {
    private String nome;
    private String cnpj;
    private List<Consulta> consultas;
}
