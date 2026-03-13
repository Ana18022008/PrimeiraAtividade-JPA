package com.weg.series.mapper;

import com.weg.series.dto.requisicao.AtorRequisicao;
import com.weg.series.dto.resposta.AtorResposta;
import com.weg.series.model.Ator;
import org.springframework.stereotype.Component;

@Component
public class AtorMapper {

    public Ator Requisicao (AtorRequisicao requisicao){
        return new Ator(
                requisicao.nome(),
                requisicao.nacionalidade(),
                requisicao.idade()
        );
    }

    public AtorResposta resposta (Ator ator){
        return new AtorResposta(
                ator.getId(),
                ator.getNome(),
                ator.getNacionalidade(),
                ator.getIdade()
        );
    }

}
