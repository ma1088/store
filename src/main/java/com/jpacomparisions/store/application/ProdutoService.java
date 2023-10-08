package com.jpacomparisions.store.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpacomparisions.store.adapters.secondary.ProdutoRepository;
import com.jpacomparisions.store.domain.Produto;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public Produto novoProduto(Produto produto) {
        return repository.save(produto);
    }
    
}
