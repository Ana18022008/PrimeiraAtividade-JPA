package com.weg.series.controller;

import com.weg.series.model.Plataforma;
import com.weg.series.service.PlataformaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataformas")
@RequiredArgsConstructor
public class PlataformaController {

    private final PlataformaService service;

    @PostMapping
    public Plataforma cadastrarPlataforma (@Valid  @RequestBody Plataforma plataforma){
        return service.cadastrarPlataforma(plataforma);
    }

    @GetMapping
    public List<Plataforma> listarPlataformas (){
        return service.listarPlataformas();
    }

    @GetMapping("/{id}")
    public Plataforma buscarPlataformaPorId (@Valid @PathVariable  int id){
        return service.buscarPlataformaPorId(id);
    }

    @PutMapping("/{id}")
    public Plataforma atualizarPlataforma (@Valid @PathVariable int id, @RequestBody Plataforma plataforma){
        return service.atualizarPlataforma(id, plataforma);
    }

    @DeleteMapping("/{id}")
    public void deletarPlataforma (@Valid @PathVariable int id){
        service.excluirPlataforma(id);
    }








}
