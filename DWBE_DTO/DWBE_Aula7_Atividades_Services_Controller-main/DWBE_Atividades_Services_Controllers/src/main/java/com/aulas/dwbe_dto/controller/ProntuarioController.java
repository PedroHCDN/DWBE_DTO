package com.aulas.dwbe_dto.controller;

import com.aulas.dwbe_dto.dto.ProntuarioRequestDTO;
import com.aulas.dwbe_dto.dto.ProntuarioResponseDTO;
import com.aulas.dwbe_dto.service.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {
    private ProntuarioService prontuarioService;

    public ProntuarioController(ProntuarioService prontuarioService){
        this.prontuarioService = prontuarioService;
    }
    @PostMapping
    public ProntuarioResponseDTO salvar(@RequestBody @Valid ProntuarioRequestDTO prontuario){
        return this.prontuarioService.salvar(prontuario);
    }
    @GetMapping("{id}")
    public ProntuarioResponseDTO porId(@PathVariable Long id){
        return this.prontuarioService.porId(id);
    }
    @GetMapping
    public List<ProntuarioResponseDTO> todos(){
        return this.prontuarioService.todos();
    }
    @PutMapping("{id}")
    public ProntuarioResponseDTO atualiar(@PathVariable Long id, @RequestBody @Valid ProntuarioRequestDTO prontuario){
        return this.prontuarioService.atualizar(id, prontuario);
    }
    @DeleteMapping("{id}")
    public String excluir(@PathVariable Long id){
        return this.prontuarioService.exclui(id);
    }
}
