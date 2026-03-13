package com.weg.series.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "atores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String nacionalidade;

    @Column (nullable = false)
    private int idade;

    public Ator(String nome, String nacionalidade, int idade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }
}
