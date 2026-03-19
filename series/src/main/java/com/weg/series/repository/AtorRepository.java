package com.weg.series.repository;

import com.weg.series.model.Ator;
import com.weg.series.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Integer> {

    Boolean ExistsById (int id);

    Optional<Ator> FindByIdAndNome(int id, String nome); // procura um ator pelo id e pelo nome

    List<Ator> FindByNomeIn (List<String> nomes); //faz a verificação se existe todos os nomes na lista

    Optional<Ator> FindNomeAndNacionalidade (String nome, String nacionalidade);

    List<Ator> FindByIdade (int idade); // retorna uma lista de atores com essa idade
}
