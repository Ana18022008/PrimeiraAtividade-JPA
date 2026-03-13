package com.weg.series.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "plataformas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plataforma {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String paisOrigem;

    @Column (nullable = false)
    private int anoCriacao;

    public Plataforma(String nome, String paisOrigem, int anoCriacao) {
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.anoCriacao = anoCriacao;
    }
}