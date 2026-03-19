package com.weg.series.repository;

import com.weg.series.model.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Integer> {

    Boolean ExistsById (int id);

    Optional<Plataforma> FindByIdAndNome(int id, String nome); // procura uma plataforma pelo id e pelo nome

    List<Plataforma> FindByNomeIn (List<String> nomes); //faz a verificação se existe todas as plataformas na lista

    Optional<Plataforma> FindNomeAndPaisOrigem (String nome, String paisOrigem);

    Optional <Plataforma> FindByAnoCriacao(int anoCriacao);

}
