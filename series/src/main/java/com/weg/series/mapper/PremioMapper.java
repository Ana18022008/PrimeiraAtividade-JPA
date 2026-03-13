package com.weg.series.mapper;

import com.weg.series.dto.requisicao.PremioRequisicao;
import com.weg.series.dto.resposta.PremioResposta;
import com.weg.series.model.Premio;
import org.springframework.stereotype.Component;

@Component
public class PremioMapper {

    public Premio requisicao (PremioRequisicao requisicao){
        return new Premio(
                requisicao.nomePremio(),
                requisicao.categoria(),
                requisicao.ano()
        );
    }

    public PremioResposta resposta (Premio premio){
        return new PremioResposta(
                premio.getId(),
                premio.getNomePremio(),
                premio.getCategoria(),
                premio.getAno()
        );
    }

}
