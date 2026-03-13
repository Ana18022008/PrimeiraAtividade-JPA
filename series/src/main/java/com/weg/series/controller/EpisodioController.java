package com.weg.series.controller;

import com.weg.series.model.Episodio;
import com.weg.series.service.EpisodioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodios")
@RequiredArgsConstructor
public class EpisodioController {

    private final EpisodioService service;


    @PostMapping
    public Episodio cadastrarEpisodio (@Valid @RequestBody Episodio episodio){
        return service.criarEpisodio(episodio);
    }

    @GetMapping
    public List<Episodio> listarEpisodios (){
        return service.listarEpisodios();
    }

    @GetMapping("/{id}")
    public Episodio buscarEpisodioPorId (@Valid @PathVariable int id){
        return service.buscarEpisodioPorId(id);
    }

    @PutMapping("/{id}")
    public Episodio atualizarEpisodio (@Valid @PathVariable int id, @RequestBody Episodio episodio){
        return service.atualizarEpisodioPorId(id, episodio);
    }

    @DeleteMapping("/{id}")
    public void deletarEpisodio (@Valid @PathVariable int id){
        service.deletarEpisodio(id);
    }



}
