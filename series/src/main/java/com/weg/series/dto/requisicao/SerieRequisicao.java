package com.weg.series.dto.requisicao;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SerieRequisicao(

       @NotEmpty
       String titulo,

       @Size(min = 4, message = "O gênero deve ter mais de 4 caracteres")
       String genero,

       @Positive
       int anoLancamento,

       @Positive
       int temporadas

) {













}
