package com.aulas.dwbe_dto.dto;

import com.aulas.dwbe_dto.model.Consulta;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceitaRequestDTO {
    private String medicamento;
    private String dosagem;
    private Integer duracaoDias;
    private Consulta consulta;
}
