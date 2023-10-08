package com.jpacomparisions.store.adapters.primary.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.DefaultResponse;
import com.jpacomparisions.store.adapters.primary.dto.PedidoDto;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @PostMapping
    public ResponseEntity<DefaultResponse> novoPedido(@RequestBody PedidoDto pedido){
        return null;
      // TODO document why this method is empty
    }
}
