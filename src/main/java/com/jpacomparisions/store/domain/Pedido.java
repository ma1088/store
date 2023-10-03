package com.jpacomparisions.store.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {
    private UUID id;
    private LocalDateTime dataPedido;
    private Pessoa pessoa;
}
