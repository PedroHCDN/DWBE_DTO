package com.aulas.dwbe_dto.service;

import com.aulas.dwbe_dto.dto.ConsultaRequestDTO;
import com.aulas.dwbe_dto.dto.ConsultaResponseDTO;
import com.aulas.dwbe_dto.model.Consulta;
import com.aulas.dwbe_dto.repository.ConsultaRepository;
import com.aulas.dwbe_dto.repository.ConvenioRepository;
import com.aulas.dwbe_dto.repository.MedicoRepository;
import com.aulas.dwbe_dto.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private ConsultaRepository consultaRepository;
    private PacienteRepository pacienteRepository;
    private MedicoRepository medicoRepository;
    private ConvenioRepository convenioRepository;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository, ConvenioRepository convenioRepository){
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
        this.convenioRepository = convenioRepository;
    }

    private Consulta toEntity(ConsultaRequestDTO consultaRequestDTO){
        Consulta user = new Consulta();
        user.setDataHora(consultaRequestDTO.getDataHora());
        user.setMotivo(consultaRequestDTO.getMotivo());
        user.setValor(consultaRequestDTO.getValor());
        user.setPaciente(consultaRequestDTO.getPaciente());
        user.setMedico(consultaRequestDTO.getMedico());
        user.setConvenio(consultaRequestDTO.getConvenio());
        return user;
    }

    //Isso parece ser muito facil pra funcionar... espero que não apareça bean de novo
    private ConsultaResponseDTO toDTO(Consulta consulta){
        return ConsultaResponseDTO.builder()
                .id(consulta.getId())
                .dataHora(consulta.getDataHora())
                .motivo(consulta.getMotivo())
                .valor(consulta.getValor())
                .paciente(consulta.getPaciente())
                .medico(consulta.getMedico())
                .convenio(consulta.getConvenio())
                .build();
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO consultaRequestDTO){
        //Nada pra verifica, ja que não tem obrigatorio
        Consulta consulta = toEntity(consultaRequestDTO);
        Consulta consultaSalvo = this.consultaRepository.save(consulta);
        return toDTO(consultaSalvo);
    }

    public List<ConsultaResponseDTO> todos(){
        return this.consultaRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ConsultaResponseDTO porId(Long id){
        Consulta consulta = this.consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        return toDTO(consulta);
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setValor(dto.getValor());
        consulta.setPaciente(dto.getPaciente());
        consulta.setMedico(dto.getMedico());
        consulta.setConvenio(dto.getConvenio());
        Consulta atualizado = consultaRepository.save(consulta);
        return toDTO(atualizado);
    }

    public String exclui(Long id){
        Consulta consulta = this.consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        this.consultaRepository.delete(consulta);
        return "Excluído com sucesso";
    }
}
