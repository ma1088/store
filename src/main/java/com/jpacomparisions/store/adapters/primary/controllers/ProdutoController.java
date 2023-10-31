package com.jpacomparisions.store.adapters.primary.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.DefaultResponse;
import com.jpacomparisions.store.adapters.primary.dto.ProdutoDto;
import com.jpacomparisions.store.adapters.primary.dto.mappers.ProdutoDtoMapper;
import com.jpacomparisions.store.application.ProdutoService;
import com.jpacomparisions.store.domain.entities.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
  @Autowired
  ProdutoService service;

  @Autowired
  ProdutoDtoMapper mapper;

  @PostMapping
  public ResponseEntity<ProdutoDto> createProduto(@RequestBody ProdutoDto produto) {
    ProdutoDto produtoDto = mapper.fromProduto(service.createProduto(mapper.toProduto(produto)));
    addSelfRel(produtoDto, produtoDto.getId());
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(produtoDto);
  }

  @GetMapping
  public ResponseEntity<List<ProdutoDto>> getProdutoByExample(@RequestParam UUID id, @RequestBody ProdutoDto exemplo) {
    Produto exemploProduto = mapper.toProduto(exemplo);
    exemploProduto.setId(id);

    List<ProdutoDto> produtos = mapper.fromProduto(service.recoverProdutos(exemploProduto));
    produtos.forEach(item -> addSelfRel(item, item.getId()));

    return ResponseEntity.ok()
        .body(produtos);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProdutoDto> updateProduto(@PathVariable UUID id, @RequestBody ProdutoDto novo) {
    Produto oNovo = mapper.toProduto(novo);
    return ResponseEntity.ok()
        .body(mapper.fromProduto(service.updateProduto(oNovo)));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<DefaultResponse> deleteProduto(@PathVariable UUID id, @RequestBody ProdutoDto excluir) {
    Produto produto = mapper.toProduto(excluir);
    produto.setId(id);
    
    service.deleteProduto(produto);

    return ResponseEntity.ok()
        .body(new DefaultResponse(Boolean.TRUE.toString()));
  }

  void addSelfRel(RepresentationModel<?> responseBody, String uuid) {
    responseBody.add(
        linkTo(methodOn(ProdutoController.class).getProdutoByExample(UUID.fromString(uuid), null))
            .withSelfRel());
  }
}
