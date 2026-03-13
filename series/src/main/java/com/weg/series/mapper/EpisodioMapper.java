package com.weg.series.mapper;

import com.weg.series.dto.requisicao.EpisodioRequisicao;
import com.weg.series.dto.resposta.EpisodioResposta;
import com.weg.series.model.Episodio;
import org.springframework.stereotype.Component;

@Component
public class EpisodioMapper {

    public Episodio requisicao (EpisodioRequisicao requisicao){
        return new Episodio(
                requisicao.titulo(),
                requisicao.duracaoMin(),
                requisicao.temporada()
        );
    }

    public EpisodioResposta resposta(Episodio episodio){
        return new EpisodioResposta(
                episodio.getId(),
                episodio.getTitulo(),
                episodio.getDuracaoMin(),
                episodio.getTemporada()
        );
    }

}
