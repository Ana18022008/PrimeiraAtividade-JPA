package com.weg.series.repository;

import com.weg.series.model.Episodio;
import com.weg.series.model.Plataforma;
import com.weg.series.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Integer> {

    Boolean ExistsById (int id);

    Optional<Episodio> FindByIdAndTitulo(int id, String titulo); // procura um episodio pelo id e pelo titulo

    List<Episodio> FindByTituloIn (List<String> titulos); //faz a verificação se existe todas os titulos na lista

    Optional<Episodio> FindTemporadaAndTitulo (String temporada, String titulo);

    Optional <Episodio> FindByAnoCriacao(int anoCriacao);

    List<Episodio> FindByTemporada (String temporada); // retorna uma lista de episódios presentes nessa temporada
}
