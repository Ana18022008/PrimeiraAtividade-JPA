package com.weg.series.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "episodios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false)
    private String titulo;

    @Column (nullable = false)
    private int duracaoMin;

    @Column (nullable = false)
    private int temporada;

    public Episodio(String titulo, int duracaoMin, int temporada) {
        this.titulo = titulo;
        this.duracaoMin = duracaoMin;
        this.temporada = temporada;
    }
}
