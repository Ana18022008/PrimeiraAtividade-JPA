package com.weg.series.controller;

import com.weg.series.dto.requisicao.AtorRequisicao;
import com.weg.series.dto.resposta.AtorResposta;
import com.weg.series.model.Ator;
import com.weg.series.service.AtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/atores")
@RequiredArgsConstructor
public class AtorController {

    private final AtorService service;

    @PostMapping
    public AtorResposta cadastrarAtor (@Valid @RequestBody AtorRequisicao requisicao){
        return service.cadastrarAtor(requisicao);
    }

    @GetMapping
    public List<AtorResposta> listarAtores (){
        return service.listarAtores();
    }

    @GetMapping("/{id}")
    public AtorResposta buscarAtorPorId (@Valid @PathVariable int id){
        return service.buscarAtorPorId(id);
    }

    @PutMapping ("/{id}")
    public AtorResposta atualizarAtor (@Valid @PathVariable int id, @RequestBody AtorRequisicao requisicao){
        return service.atualizarAtor(id, requisicao);
    }

    @DeleteMapping("/{id}")
    public void deletarAtor (@Valid @PathVariable int id){
        service.deletarAtor(id);
    }




}
