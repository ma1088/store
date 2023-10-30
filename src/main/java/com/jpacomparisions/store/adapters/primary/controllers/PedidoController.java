package com.jpacomparisions.store.adapters.primary.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.PedidoDto;
import com.jpacomparisions.store.adapters.primary.dto.mappers.PedidoDtoMapper;
import com.jpacomparisions.store.application.PedidoService;
import com.jpacomparisions.store.domain.Pedido;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
  @Autowired
  PedidoService service;
  @Autowired
  PedidoDtoMapper mapper;

  @PostMapping
  public ResponseEntity<PedidoDto> novoPedido(@RequestBody PedidoDto pedido) {
    PedidoDto responseBody = mapper.fromPedido(service.createPedido(mapper.toPedido(pedido)));
    addSelfRel(responseBody, pedido.getId());
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(responseBody);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<List<PedidoDto>> recoverPedidos(@PathVariable UUID id, @RequestBody PedidoDto exemplo) {
    Pedido pedido = mapper.toPedido(exemplo);
    pedido.setId(id);

    List<PedidoDto> pedidos = mapper.fromPedido(service.recoverPedidos(pedido));
    pedidos.forEach(item -> addSelfRel(item, item.getId()));

    return ResponseEntity.ok().body(pedidos);
  }

  void addSelfRel(RepresentationModel<?> responseBody, String uuid) {
    responseBody.add(
        linkTo(methodOn(PedidoController.class).recoverPedidos(UUID.fromString(uuid), null))
            .withSelfRel());
  }
}
