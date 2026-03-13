package com.weg.series.controller;

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
    public Serie cadastrarSerie (@Valid  @RequestBody Serie serie){
        return service.cadastrarSerie(serie);
    }

    @GetMapping
    public List<Serie> listarSeries (){
        return service.listarSeries();
    }

    @GetMapping ("/{id}")
    public Serie buscarSeriePorId (@Valid @PathVariable int id){
        return service.buscarSeriePorId(id);
    }

    @PutMapping ("/{id}")
    public Serie atualizarSerie (@Valid @PathVariable int id, @RequestBody Serie serie){
        return service.atualizarSerie(id, serie);
    }

    @DeleteMapping ("/{id}")
    public void deletarSerie (@Valid @PathVariable int id){
        service.deletarSerie(id);
    }
}
