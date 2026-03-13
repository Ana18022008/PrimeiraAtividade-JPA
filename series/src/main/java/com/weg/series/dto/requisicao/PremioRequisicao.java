package com.weg.series.dto.requisicao;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record PremioRequisicao(

        @NotEmpty
        String nomePremio,

        @NotEmpty
        String categoria,

        @Positive
        int ano

) {
}
