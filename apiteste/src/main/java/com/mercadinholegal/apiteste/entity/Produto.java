package com.mercadinholegal.apiteste.entity;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "categoria_produto")
    private String categoriaProduto;

    @Column(name = "valor_produto")
    private Double valorProduto;

    public Produto() {
    }

    public Produto(Long idProduto, String nomeProduto, String categoriaProduto, Double valorProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.valorProduto = valorProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }
}