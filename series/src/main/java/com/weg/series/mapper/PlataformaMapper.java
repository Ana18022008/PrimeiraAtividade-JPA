package com.weg.series.mapper;

import com.weg.series.dto.requisicao.PlataformaRequisicao;
import com.weg.series.dto.resposta.PlataformaResposta;
import com.weg.series.model.Plataforma;
import org.springframework.stereotype.Component;

@Component
public class PlataformaMapper {

    public Plataforma requisicao (PlataformaRequisicao requisicao){
        return new Plataforma(
                requisicao.nome(),
                requisicao.paisOrigem(),
                requisicao.anoCriacao()
        );
    }

    public PlataformaResposta resposta(Plataforma plataforma){
        return new PlataformaResposta(
                plataforma.getId(),
                plataforma.getNome(),
                plataforma.getPaisOrigem(),
                plataforma.getAnoCriacao()

        );
    }


}
