package com.weg.series.service;

import com.weg.series.dto.requisicao.PlataformaRequisicao;
import com.weg.series.dto.resposta.PlataformaResposta;
import com.weg.series.mapper.PlataformaMapper;
import com.weg.series.model.Plataforma;
import com.weg.series.repository.PlataformaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlataformaService {
    private final PlataformaRepository repository;
    private final PlataformaMapper mapper;

    public PlataformaResposta cadastrarPlataforma (PlataformaRequisicao requisicao){

        return mapper.resposta(repository.save(mapper.requisicao(requisicao)));
    }

    public List<PlataformaResposta> listarPlataformas (){
        List<Plataforma> plataformas = repository.findAll();
        List<PlataformaResposta> plataformaR = new ArrayList<>();

        plataformas.forEach(plataforma -> {
            plataformaR.add(mapper.resposta(plataforma));
        });


        return plataformaR;
    }

    public PlataformaResposta buscarPlataformaPorId (int id){

        return mapper.resposta(repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Plataforma não encontrada!")));


    }

    public PlataformaResposta atualizarPlataforma (int id, PlataformaRequisicao requisicao){

        Plataforma plataformaSalva = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Plataforma não encontrada!"));

        plataformaSalva.setNome(requisicao.nome());
        plataformaSalva.setPaisOrigem(requisicao.paisOrigem());
        plataformaSalva.setAnoCriacao(requisicao.anoCriacao());

        return mapper.resposta(repository.save(plataformaSalva));

    }

    public void excluirPlataforma (int id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Plataforma não encontrada!");
        }

        repository.deleteById(id);
    }

}
