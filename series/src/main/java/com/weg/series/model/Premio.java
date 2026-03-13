package com.weg.series.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "premios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false)
    private String nomePremio;

    @Column (nullable = false)
    private String categoria;

    @Column (nullable = false)
    private int ano;

    public Premio(String nomePremio, String categoria, int ano) {
        this.nomePremio = nomePremio;
        this.categoria = categoria;
        this.ano = ano;
    }
}
