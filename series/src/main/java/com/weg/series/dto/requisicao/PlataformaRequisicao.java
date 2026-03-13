package com.weg.series.dto.requisicao;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PlataformaRequisicao(

        @Size(min = 5, max = 40, message = "O nome da plataforma deve ter entre 5 e 40 caracteres")
        String nome,

        @NotEmpty
        String paisOrigem,

        @Positive
        int anoCriacao
){}
