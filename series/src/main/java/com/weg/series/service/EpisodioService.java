package com.weg.series.service;

import com.weg.series.model.Episodio;
import com.weg.series.repository.EpisodioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodioService {

    private final EpisodioRepository repository;

    public Episodio criarEpisodio (Episodio episodio){

        return repository.save(episodio);
    }

    public List<Episodio> listarEpisodios (){
        return repository.findAll();
    }

    public Episodio buscarEpisodioPorId (int id){

        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Episódio não encontrado"));

    }

    public Episodio atualizarEpisodioPorId (int id, Episodio episodio){

        Episodio episodioSalvo = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Episódio não encontrado"));

        episodioSalvo.setTitulo(episodio.getTitulo());
        episodioSalvo.setDuracaoMin(episodio.getDuracaoMin());
        episodioSalvo.setTemporada(episodio.getTemporada());

        return repository.save(episodioSalvo);



}

    public void deletarEpisodio (int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Episódio não encontrado");
        }


        repository.deleteById(id);
    }
}