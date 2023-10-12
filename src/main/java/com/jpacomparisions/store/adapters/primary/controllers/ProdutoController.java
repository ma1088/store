package com.jpacomparisions.store.adapters.primary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.ProdutoDto;
import com.jpacomparisions.store.adapters.primary.dto.mappers.ProdutoDtoMapper;
import com.jpacomparisions.store.application.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
  @Autowired
  ProdutoService service;

  @Autowired
  ProdutoDtoMapper mapper;

  @PostMapping
  public ResponseEntity<ProdutoDto> createProduto(@RequestBody ProdutoDto produto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapper.fromProduto(service.createProduto(mapper.toProduto(produto))));
  }
}
