package com.mercadinholegal.apiteste.controller;

import com.mercadinholegal.apiteste.entity.Produto;
import com.mercadinholegal.apiteste.pojo.ProdutoPojo;
import com.mercadinholegal.apiteste.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import com.mercadinholegal.apiteste.pojo.ProdutoPojo;
import com.mercadinholegal.apiteste.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity<ProdutoPojo> create(@RequestBody @Validated ProdutoPojo produtoPojo) {
        Produto produto = produtoPojo.toEntity();
        produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoPojo);
    }

    @GetMapping
    public List<ProdutoPojo> getAll() {
        List<Produto> listProduto = produtoRepository.findAll();
        List<ProdutoPojo> listProdutoPojo = new ArrayList<>();
        for (Produto produto: listProduto) {
            listProdutoPojo.add(new ProdutoPojo(produto));
        }
        return listProdutoPojo;
    }

    @GetMapping(path = "/{idProduto}")
    public ResponseEntity<ProdutoPojo> get(@PathVariable Long idProduto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(idProduto);
        if(produtoOptional.isPresent()) {
            return ResponseEntity.ok(new ProdutoPojo(produtoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<ProdutoPojo> update(@RequestBody @Validated ProdutoPojo produtoPojo) {
        Produto produto = produtoRepository.findById(produtoPojo.toEntity().getIdProduto()).get();
        produto.setNomeProduto(produtoPojo.toEntity().getNomeProduto());
        produto.setCategoriaProduto(produtoPojo.toEntity().getCategoriaProduto());
        produto.setValorProduto(produtoPojo.toEntity().getValorProduto());
        produtoRepository.save(produto);
        return ResponseEntity.ok(produtoPojo);
    }

    @DeleteMapping(path = "/{idProduto}")
    public ResponseEntity<Void> delete(@PathVariable Long idProduto) {
        produtoRepository.deleteById(idProduto);
        return ResponseEntity.ok().build();
    }

}