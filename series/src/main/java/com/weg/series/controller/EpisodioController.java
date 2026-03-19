package com.weg.series.controller;

import com.weg.series.dto.requisicao.EpisodioRequisicao;
import com.weg.series.dto.resposta.EpisodioResposta;
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
    public EpisodioResposta cadastrarEpisodio (@Valid @RequestBody EpisodioRequisicao requisicao){
        return service.criarEpisodio(requisicao);
    }

    @GetMapping
    public List<EpisodioResposta> listarEpisodios (){
        return service.listarEpisodios();
    }

    @GetMapping("/{id}")
    public EpisodioResposta buscarEpisodioPorId (@Valid @PathVariable int id){
        return service.buscarEpisodioPorId(id);
    }

    @PutMapping("/{id}")
    public EpisodioResposta atualizarEpisodio (@Valid @PathVariable int id, @RequestBody EpisodioRequisicao requisicao){
        return service.atualizarEpisodioPorId(id, requisicao);
    }

    @DeleteMapping("/{id}")
    public void deletarEpisodio (@Valid @PathVariable int id){
        service.deletarEpisodio(id);
    }



}
