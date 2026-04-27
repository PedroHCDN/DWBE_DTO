package com.aulas.dwbe_dto.controller;

import com.aulas.dwbe_dto.dto.ConvenioRequestDTO;
import com.aulas.dwbe_dto.dto.ConvenioResponseDTO;
import com.aulas.dwbe_dto.service.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {
    private ConvenioService convenioService;

    public ConvenioController(ConvenioService convenioService){
        this.convenioService = convenioService;
    }
    @PostMapping
    public ConvenioResponseDTO salvar(@RequestBody @Valid ConvenioRequestDTO convenio){
        return this.convenioService.salvar(convenio);
    }
    @GetMapping("{id}")
    public ConvenioResponseDTO porId(@PathVariable Long id){
        return this.convenioService.porId(id);
    }
    @GetMapping
    public List<ConvenioResponseDTO> todos(){
        return this.convenioService.todos();
    }
    @PutMapping("{id}")
    public ConvenioResponseDTO atualiar(@PathVariable Long id, @RequestBody @Valid ConvenioRequestDTO convenio){
        return this.convenioService.atualizar(id, convenio);
    }
    @DeleteMapping("{id}")
    public String excluir(@PathVariable Long id){
        return this.convenioService.exclui(id);
    }
}
