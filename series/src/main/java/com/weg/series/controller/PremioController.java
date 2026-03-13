package com.weg.series.controller;

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
    public Premio cadastrarPremio (@Valid  @RequestBody Premio premio){
        return service.cadastrarPremio(premio);
    }

    @GetMapping
    public List<Premio> listarPremios (){
        return service.listarPremios();
    }

    @GetMapping("/{id}")
    public Premio buscarPremioPorId (@Valid @PathVariable int id){
        return service.buscarPremioPorId(id);
    }

    @PutMapping("/{id}")
    public Premio atualizarPremio (@Valid @PathVariable int id, @RequestBody Premio premio){
        return service.atualizarPremioPorId(id, premio);
    }

    @DeleteMapping("/{id}")
    public void deletarPremio (@Valid @PathVariable int id){
        service.excluirPremio(id);
    }












}
