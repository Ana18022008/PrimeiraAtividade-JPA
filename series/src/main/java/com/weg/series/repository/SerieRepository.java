package com.weg.series.repository;

import com.weg.series.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {

    Boolean ExistsById (int id); //Faz uma verificação se existe a série com o id passado

    Optional <Serie> FindByIdAndTitulo(int id, String titulo); //Procura a série que tenha o id e o título pesquisados

    List<Serie> FindByTituloIn (List<String> titulos); //Faz uma verificação se existe todos os títulos da lista

    Optional<Serie> FindTituloAndGenero (String titulo, String genero); //retorna a série que possui o titulo e genero passados

    Optional <Serie> FindByTitulo(String titulo); //retorna a série com o título passado

    List<Serie> FindByGenero (String genero); // retorna uma lista de séries com esse gênero
}
