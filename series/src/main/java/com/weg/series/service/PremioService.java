package com.weg.series.service;

import com.weg.series.model.Premio;
import com.weg.series.repository.PremioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PremioService {

    private final PremioRepository repository;

    public Premio cadastrarPremio (Premio premio){

        return repository.save(premio);

    }

    public List<Premio> listarPremios (){
        return repository.findAll();
    }

    public Premio buscarPremioPorId (int id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Prêmio não encontrado!"));
    }

    public Premio atualizarPremioPorId (int id, Premio premio){

        Premio premioSalvo = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Prêmio não encontrado"));

        premioSalvo.setNomePremio(premio.getNomePremio());
        premioSalvo.setCategoria(premio.getCategoria());
        premioSalvo.setAno(premio.getAno());

        return repository.save(premioSalvo);
    }

    public void excluirPremio (int id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Prêmio não encontrado!");
        }

        repository.deleteById(id);
    }

}
