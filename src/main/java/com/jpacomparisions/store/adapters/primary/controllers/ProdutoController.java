package com.jpacomparisions.store.adapters.primary.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.DefaultResponse;
import com.jpacomparisions.store.adapters.primary.dto.HateoasResponse;
import com.jpacomparisions.store.adapters.primary.dto.ProdutoDto;
import com.jpacomparisions.store.adapters.primary.dto.mappers.ProdutoDtoMapper;
import com.jpacomparisions.store.application.ProdutoService;
import com.jpacomparisions.store.domain.Produto;

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

  @GetMapping(value = "/{id}")
  public ResponseEntity<List<ProdutoDto>> getById(@PathVariable UUID id) {
    return ResponseEntity.ok()
        .body(mapper.fromProduto(service.recoverProdutos(new Produto(id, null, null))));
  }

  @GetMapping
  public ResponseEntity<List<ProdutoDto>> getProdutoByExample(@RequestBody ProdutoDto exemplo) {
    return ResponseEntity.ok()
        .body(mapper.fromProduto(service.recoverProdutos(mapper.toProduto(exemplo))));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProdutoDto> updateProduto(@PathVariable UUID id, @RequestBody ProdutoDto novo) {
    Produto oNovo = new Produto(id, novo.descricao(), novo.validade());
    return ResponseEntity.ok()
        .body(mapper.fromProduto(service.updateProduto(oNovo)));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<DefaultResponse> deleteProduto(@PathVariable UUID id, @RequestBody ProdutoDto excluir) {
    service.deleteProduto(new Produto(id, excluir.descricao(), excluir.validade()));

    return ResponseEntity.ok()
        .body(new DefaultResponse(Boolean.TRUE.toString()));
  }

  @DeleteMapping(value = "/hateoas/{id}")
  public ResponseEntity<HateoasResponse> deleteProdutoHateoasResponse(@PathVariable UUID id,
      @RequestBody ProdutoDto excluir) {
    service.deleteProduto(new Produto(id, excluir.descricao(), excluir.validade()));

    HateoasResponse responseBody = new HateoasResponse(Boolean.TRUE.toString());
    return ResponseEntity.ok()
        .body(responseBody);
  }

}
