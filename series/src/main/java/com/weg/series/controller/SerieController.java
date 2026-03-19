package com.weg.series.controller;

import com.weg.series.dto.requisicao.SerieRequisicao;
import com.weg.series.dto.resposta.SerieResposta;
import com.weg.series.model.Serie;
import com.weg.series.service.SerieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SerieController {

    private final SerieService service;

    @PostMapping
    public SerieResposta cadastrarSerie (@Valid  @RequestBody SerieRequisicao requisicao){
        return service.cadastrarSerie(requisicao);
    }

    @GetMapping
    public List<SerieResposta> listarSeries (){
        return service.listarSeries();
    }

    @GetMapping ("/{id}")
    public SerieResposta buscarSeriePorId (@Valid @PathVariable int id){
        return service.buscarSeriePorId(id);
    }

    @PutMapping ("/{id}")
    public SerieResposta atualizarSerie (@Valid @PathVariable int id, @RequestBody SerieRequisicao requisicao){
        return service.atualizarSerie(id, requisicao);
    }

    @DeleteMapping ("/{id}")
    public void deletarSerie (@Valid @PathVariable int id){
        service.deletarSerie(id);
    }
}
