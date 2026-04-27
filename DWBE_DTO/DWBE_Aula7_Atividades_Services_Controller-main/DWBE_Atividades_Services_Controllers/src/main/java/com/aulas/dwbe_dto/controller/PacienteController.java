package com.aulas.dwbe_dto.controller;

import com.aulas.dwbe_dto.dto.PacienteRequestDTO;
import com.aulas.dwbe_dto.dto.PacienteResponseDTO;
import com.aulas.dwbe_dto.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }
    @PostMapping
    public PacienteResponseDTO salvar(@RequestBody @Valid PacienteRequestDTO paciente){
        return this.pacienteService.salvar(paciente);
    }
    @GetMapping("{id}")
    public PacienteResponseDTO porId(@PathVariable Long id){
        return this.pacienteService.porId(id);
    }
    @GetMapping
    public List<PacienteResponseDTO> todos(){
        return this.pacienteService.todos();
    }
    @PutMapping("{id}")
    public PacienteResponseDTO atualiar(@PathVariable Long id, @RequestBody @Valid PacienteRequestDTO paciente){
        return this.pacienteService.atualizar(id, paciente);
    }
    @DeleteMapping("{id}")
    public String excluir(@PathVariable Long id){
        return this.pacienteService.exclui(id);
    }
}
