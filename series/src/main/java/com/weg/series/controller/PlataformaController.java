package com.weg.series.controller;

import com.weg.series.dto.requisicao.PlataformaRequisicao;
import com.weg.series.dto.resposta.PlataformaResposta;
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
    public PlataformaResposta cadastrarPlataforma (@Valid  @RequestBody PlataformaRequisicao requisicao){
        return service.cadastrarPlataforma(requisicao);
    }

    @GetMapping
    public List<PlataformaResposta> listarPlataformas (){
        return service.listarPlataformas();
    }

    @GetMapping("/{id}")
    public PlataformaResposta buscarPlataformaPorId (@Valid @PathVariable  int id){
        return service.buscarPlataformaPorId(id);
    }

    @PutMapping("/{id}")
    public PlataformaResposta atualizarPlataforma (@Valid @PathVariable int id, @RequestBody PlataformaRequisicao requisicao){
        return service.atualizarPlataforma(id, requisicao);
    }

    @DeleteMapping("/{id}")
    public void deletarPlataforma (@Valid @PathVariable int id){
        service.excluirPlataforma(id);
    }








}
