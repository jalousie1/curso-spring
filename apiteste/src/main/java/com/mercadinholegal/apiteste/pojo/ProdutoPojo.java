package com.mercadinholegal.apiteste.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadinholegal.apiteste.entity.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProdutoPojo {

    @JsonProperty("id_produto")
    private Long idProduto;

    @JsonProperty("nome_produto")
    private String nomeProduto;

    @JsonProperty("categoria_produto")
    private String categoriaProduto;

    @JsonProperty("valor_produto")
    private Double valorProduto;

    public ProdutoPojo() {}

    public ProdutoPojo(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.categoriaProduto = produto.getCategoriaProduto();
        this.valorProduto = produto.getValorProduto();
    }

    @JsonIgnore
    public Produto toEntity() {
        Produto produto = new Produto();
        produto.setIdProduto(idProduto);
        produto.setNomeProduto(nomeProduto);
        produto.setCategoriaProduto(categoriaProduto);
        produto.setValorProduto(valorProduto);
        return produto;
    }
}
