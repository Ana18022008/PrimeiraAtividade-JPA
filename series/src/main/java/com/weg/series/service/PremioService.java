package com.weg.series.service;

import com.weg.series.dto.requisicao.PremioRequisicao;
import com.weg.series.dto.resposta.PremioResposta;
import com.weg.series.mapper.PremioMapper;
import com.weg.series.model.Premio;
import com.weg.series.repository.PremioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PremioService {

    private final PremioRepository repository;
    private final PremioMapper mapper;

    public PremioResposta cadastrarPremio (PremioRequisicao requisicao){

        return mapper.resposta(repository.save(mapper.requisicao(requisicao)));

    }

    public List<PremioResposta> listarPremios (){
       List<Premio> premios = repository.findAll();
       List<PremioResposta> premiosR = new ArrayList<>();

       premios.forEach(premio -> {
           premiosR.add(mapper.resposta(premio));
       });

        return premiosR;
    }

    public PremioResposta buscarPremioPorId (int id){
        return mapper.resposta(repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Prêmio não encontrado!")));
    }

    public PremioResposta atualizarPremioPorId (int id, PremioRequisicao requisicao){

        Premio premioSalvo = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Prêmio não encontrado"));

        premioSalvo.setNomePremio(requisicao.nomePremio());
        premioSalvo.setCategoria(requisicao.categoria());
        premioSalvo.setAno(requisicao.ano());

        return mapper.resposta(repository.save(premioSalvo));
    }

    public void excluirPremio (int id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Prêmio não encontrado!");
        }

        repository.deleteById(id);
    }

}
