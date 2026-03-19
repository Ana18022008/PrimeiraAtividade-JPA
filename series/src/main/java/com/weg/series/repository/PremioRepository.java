package com.weg.series.repository;

import com.weg.series.model.Premio;
import com.weg.series.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PremioRepository extends JpaRepository<Premio, Integer> {

    Boolean ExistsById (int id);

    Optional<Premio> FindByIdAndNome(int id, String nome); // procura um prêmio pelo id e pelo nome

    List<Premio> FindByNomePremioIn (List<String> nomesPremios); //faz a verificação se existe todos os premios na lista

    Optional<Premio> FindNomeAndCategoria (String nome, String categoria);

    Optional <Premio> FindByAno(int ano);

    List<Serie> FindByCategoria (String categoria); // retorna uma lista de prêmios com essa categoria

}
