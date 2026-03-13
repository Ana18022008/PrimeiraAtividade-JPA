package com.weg.series.service;

import com.weg.series.model.Plataforma;
import com.weg.series.repository.PlataformaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlataformaService {
    private final PlataformaRepository repository;

    public Plataforma cadastrarPlataforma (Plataforma plataforma){

        return repository.save(plataforma);
    }

    public List<Plataforma> listarPlataformas (){
        return repository.findAll();
    }

    public Plataforma buscarPlataformaPorId (int id){

        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Plataforma não encontrada!"));


    }

    public Plataforma atualizarPlataforma (int id, Plataforma plataforma){

        Plataforma plataformaSalva = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Plataforma não encontrada!"));

        plataformaSalva.setNome(plataforma.getNome());
        plataformaSalva.setPaisOrigem(plataforma.getPaisOrigem());
        plataformaSalva.setAnoCriacao(plataforma.getAnoCriacao());

        return repository.save(plataformaSalva);

    }

    public void excluirPlataforma (int id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Plataforma não encontrada!");
        }

        repository.deleteById(id);
    }

}
