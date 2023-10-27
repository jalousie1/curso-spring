package com.mercadinholegal.apiteste.repository;

import com.mercadinholegal.apiteste.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

