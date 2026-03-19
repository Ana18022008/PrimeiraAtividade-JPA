package com.weg.series.service;

import com.weg.series.dto.requisicao.EpisodioRequisicao;
import com.weg.series.dto.resposta.EpisodioResposta;
import com.weg.series.mapper.EpisodioMapper;
import com.weg.series.model.Episodio;
import com.weg.series.repository.EpisodioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodioService {

    private final EpisodioRepository repository;
    private final EpisodioMapper mapper;

    public EpisodioResposta criarEpisodio (EpisodioRequisicao requisicao){

        return mapper.resposta(repository.save(mapper.requisicao(requisicao)));
    }

    public List<EpisodioResposta> listarEpisodios (){
        List<Episodio> episodios = repository.findAll();
        List<EpisodioResposta> episodiosR = new ArrayList<>();

        episodios.forEach(episodio -> {
            episodiosR.add(mapper.resposta(episodio));
        });


        return episodiosR;
    }

    public EpisodioResposta buscarEpisodioPorId (int id){

        return mapper.resposta(repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Episódio não encontrado")));


    }

    public EpisodioResposta atualizarEpisodioPorId (int id, EpisodioRequisicao requisicao){

        Episodio episodioSalvo = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Episódio não encontrado"));

        episodioSalvo.setTitulo(requisicao.titulo());
        episodioSalvo.setDuracaoMin(requisicao.duracaoMin());
        episodioSalvo.setTemporada(requisicao.temporada());

        return mapper.resposta(repository.save(episodioSalvo));



}

    public void deletarEpisodio (int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Episódio não encontrado");
        }


        repository.deleteById(id);
    }
}