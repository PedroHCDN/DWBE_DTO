package com.aulas.dwbe_dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProntuarioRequestDTO {
    private String tipoSanguineo;
    private String alergia;
    private String observacoes;
}
