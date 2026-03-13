package com.weg.series.service;

import com.weg.series.model.Serie;
import com.weg.series.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService {

    private final SerieRepository repository;

    public Serie cadastrarSerie (Serie serie){

        return repository.save(serie);
    }

    public List<Serie> listarSeries (){
        return repository.findAll();
    }

    public Serie buscarSeriePorId (int id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Série não encontrada!"));
    }

    public Serie atualizarSerie (int id, Serie serie){
        Serie serieSalva = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Série não encontrada!"));

        serieSalva.setTitulo(serie.getTitulo());
        serieSalva.setGenero(serie.getGenero());
        serieSalva.setAnoLancamento(serie.getAnoLancamento());
        serieSalva.setTemporadas(serie.getTemporadas());

        return repository.save(serieSalva);

    }

    public void deletarSerie (int id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Série não encontrada!");
        }

        repository.deleteById(id);
    }




}
