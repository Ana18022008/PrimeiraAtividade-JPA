package com.weg.series.service;

import com.weg.series.dto.requisicao.AtorRequisicao;
import com.weg.series.dto.resposta.AtorResposta;
import com.weg.series.mapper.AtorMapper;
import com.weg.series.model.Ator;
import com.weg.series.repository.AtorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtorService {
   private final AtorRepository repository;
   private final AtorMapper mapper;

   public AtorResposta cadastrarAtor (AtorRequisicao requisicao){

       return mapper.resposta(repository.save(mapper.Requisicao(requisicao)));

   }

    public List<AtorResposta> listarAtores (){

       List<Ator> atores = repository.findAll();
       List<AtorResposta> lista = new ArrayList<>();

       atores.forEach(ator -> {
           lista.add(mapper.resposta(ator));
       });

       return lista;

    }

    public AtorResposta buscarAtorPorId (int id){
       return mapper.resposta(repository.findById(id)
               .orElseThrow(()-> new RuntimeException("Ator não encontrado")));
    }

    public AtorResposta atualizarAtor (int id, AtorRequisicao requisicao){

       Ator atorSalvo = repository.findById(id)
               .orElseThrow(()-> new RuntimeException("Ator não encontrado"));

       atorSalvo.setNome(requisicao.nome());
       atorSalvo.setNacionalidade(requisicao.nacionalidade());
       atorSalvo.setIdade(requisicao.idade());

       return mapper.resposta(repository.save(atorSalvo));
    }

    public void deletarAtor (int id){

       if (!repository.existsById(id)){
           throw new RuntimeException("Ator não encontrado!");
       }
        repository.deleteById(id);
    }
}
