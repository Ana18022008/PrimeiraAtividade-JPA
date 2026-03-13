package com.weg.series.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "series")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false)
    private String titulo;

    @Column (nullable = false)
    private String genero;

    @Column (nullable = false)
    private int anoLancamento;

    @Column (nullable = false)
    private int temporadas;

    public Serie(String titulo, String genero, int anoLancamento, int temporadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.temporadas = temporadas;
    }
}