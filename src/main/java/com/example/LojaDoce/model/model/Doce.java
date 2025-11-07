package com.example.LojaDoce.model.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Doce")
public class Doce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Integer quantidade;
    private Double valor;

    // Construtores
    public Doce() {}
    public Doce(String nome, Integer quantidade, Double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    // getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
}
