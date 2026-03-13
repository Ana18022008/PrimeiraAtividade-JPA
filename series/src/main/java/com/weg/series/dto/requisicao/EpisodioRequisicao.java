package com.weg.series.dto.requisicao;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record EpisodioRequisicao(

        @Size(min = 1, max = 40, message = "O título do episódio deve ter entre 1 e 40 caracteres")
        String titulo,

        @Positive
        int duracaoMin,

        @Positive
        int temporada


) {
}
