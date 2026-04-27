package com.aulas.dwbe_dto.service;

import com.aulas.dwbe_dto.dto.ProntuarioRequestDTO;
import com.aulas.dwbe_dto.dto.ProntuarioResponseDTO;
import com.aulas.dwbe_dto.model.Prontuario;
import com.aulas.dwbe_dto.repository.ProntuarioRepository;

import java.util.List;

public class ProntuarioService {
    private ProntuarioRepository prontuarioRepository;

    public ProntuarioService(ProntuarioRepository prontuarioRepository){
        this.prontuarioRepository = prontuarioRepository;
    }

    private Prontuario toEntity(ProntuarioRequestDTO prontuarioRequestDTO){
        Prontuario user = new Prontuario();
        user.setTipoSanguineo(prontuarioRequestDTO.getTipoSanguineo());
        user.setAlergia(prontuarioRequestDTO.getAlergia());
        user.setObservacoes(prontuarioRequestDTO.getObservacoes());
        return user;
    }

    private ProntuarioResponseDTO toDTO(Prontuario prontuario){
        return ProntuarioResponseDTO.builder()
                .id(prontuario.getId())
                .tipoSanguineo(prontuario.getTipoSanguineo())
                .alergia(prontuario.getAlergia())
                .observacoes(prontuario.getObservacoes())
                .build();
    }

    public ProntuarioResponseDTO salvar(ProntuarioRequestDTO prontuarioRequestDTO){
        //Nada pra verifica, ja que não tem obrigatorio
        Prontuario prontuario = toEntity(prontuarioRequestDTO);
        Prontuario prontuarioSalvo = this.prontuarioRepository.save(prontuario);
        return toDTO(prontuarioSalvo);
    }

    public List<ProntuarioResponseDTO> todos(){
        return this.prontuarioRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ProntuarioResponseDTO porId(Long id){
        Prontuario prontuario = this.prontuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuario não encontrado"));
        return toDTO(prontuario);
    }

    public ProntuarioResponseDTO atualizar(Long id, ProntuarioRequestDTO dto){
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuario não encontrado"));
        prontuario.setTipoSanguineo(dto.getTipoSanguineo());
        prontuario.setAlergia(dto.getAlergia());
        prontuario.setObservacoes(dto.getObservacoes());
        Prontuario atualizado = prontuarioRepository.save(prontuario);
        return toDTO(atualizado);
    }

    public String exclui(Long id){
        Prontuario prontuario = this.prontuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuario não encontrado"));
        this.prontuarioRepository.delete(prontuario);
        return "Excluído com sucesso";
    }
}
