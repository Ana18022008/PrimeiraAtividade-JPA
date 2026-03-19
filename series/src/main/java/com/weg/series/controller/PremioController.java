package com.weg.series.controller;

import com.weg.series.dto.requisicao.PremioRequisicao;
import com.weg.series.dto.resposta.PremioResposta;
import com.weg.series.model.Premio;
import com.weg.series.service.PremioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/premios")
@RequiredArgsConstructor
public class PremioController {

    private final PremioService service;

    @PostMapping
    public PremioResposta cadastrarPremio (@Valid  @RequestBody PremioRequisicao requisicao){
        return service.cadastrarPremio(requisicao);
    }

    @GetMapping
    public List<PremioResposta> listarPremios (){
        return service.listarPremios();
    }

    @GetMapping("/{id}")
    public PremioResposta buscarPremioPorId (@Valid @PathVariable int id){
        return service.buscarPremioPorId(id);
    }

    @PutMapping("/{id}")
    public PremioResposta atualizarPremio (@Valid @PathVariable int id, @RequestBody PremioRequisicao requisicao){
        return service.atualizarPremioPorId(id, requisicao);
    }

    @DeleteMapping("/{id}")
    public void deletarPremio (@Valid @PathVariable int id){
        service.excluirPremio(id);
    }












}
