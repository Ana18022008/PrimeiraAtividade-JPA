package com.weg.series.mapper;

import com.weg.series.dto.requisicao.SerieRequisicao;
import com.weg.series.dto.resposta.SerieResposta;
import com.weg.series.model.Serie;
import org.springframework.stereotype.Component;

@Component
public class SerieMapper {

    public Serie requisicao (SerieRequisicao requisicao){
        return new Serie(
                requisicao.titulo(),
                requisicao.genero(),
                requisicao.anoLancamento(),
                requisicao.temporadas()
        );
    }

    public SerieResposta resposta(Serie serie){
        return new SerieResposta(
                serie.getId(),
                serie.getTitulo(),
                serie.getGenero(),
                serie.getAnoLancamento(),
                serie.getTemporadas()
        );
    }

}
