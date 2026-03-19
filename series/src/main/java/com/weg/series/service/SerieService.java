package com.weg.series.service;

import com.weg.series.dto.requisicao.SerieRequisicao;
import com.weg.series.dto.resposta.SerieResposta;
import com.weg.series.mapper.SerieMapper;
import com.weg.series.model.Serie;
import com.weg.series.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService {

    private final SerieRepository repository;
    private final SerieMapper mapper;

    public SerieResposta cadastrarSerie (SerieRequisicao requisicao){

        return mapper.resposta(repository.save(mapper.requisicao(requisicao)));
    }

    public List<SerieResposta> listarSeries (){
       List<Serie> series = repository.findAll();
       List<SerieResposta> seriesR = new ArrayList<>();

       series.forEach(serie -> {
           seriesR.add(mapper.resposta(serie));
       });

        return seriesR;
    }

    public SerieResposta buscarSeriePorId (int id){
        return mapper.resposta(repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Série não encontrada!")));
    }

    public SerieResposta atualizarSerie (int id, SerieRequisicao requisicao){
        Serie serieSalva = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Série não encontrada!"));

        serieSalva.setTitulo(requisicao.titulo());
        serieSalva.setGenero(requisicao.genero());
        serieSalva.setAnoLancamento(requisicao.anoLancamento());
        serieSalva.setTemporadas(requisicao.temporadas());

        return mapper.resposta(repository.save(serieSalva));

    }

    public void deletarSerie (int id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Série não encontrada!");
        }

        repository.deleteById(id);
    }




}
