package com.weg.series.dto.requisicao;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AtorRequisicao(
     @Size(min=5, max = 60, message = "O nome do ator deve ter entre 5 e 60 caracteres")
     String nome,
     @NotEmpty
     String nacionalidade,
     @Positive
     int idade


) {
}
