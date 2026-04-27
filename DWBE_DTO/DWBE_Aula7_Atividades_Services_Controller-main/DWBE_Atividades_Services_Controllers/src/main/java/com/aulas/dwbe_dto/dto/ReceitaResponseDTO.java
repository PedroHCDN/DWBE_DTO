package com.aulas.dwbe_dto.dto;

import com.aulas.dwbe_dto.model.Consulta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaResponseDTO {
    private Long id;
    private String medicamento;
    private String dosagem;
    private Integer duracaoDias;
    private Consulta consulta;
}
