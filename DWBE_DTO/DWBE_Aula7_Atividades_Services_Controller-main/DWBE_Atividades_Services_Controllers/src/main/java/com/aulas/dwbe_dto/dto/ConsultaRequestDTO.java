package com.aulas.dwbe_dto.dto;

import com.aulas.dwbe_dto.model.Convenio;
import com.aulas.dwbe_dto.model.Medico;
import com.aulas.dwbe_dto.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaRequestDTO {
    private Date dataHora;
    private String motivo;
    private Double valor;
    private Paciente paciente;
    private Medico medico;
    private Convenio convenio;
}
