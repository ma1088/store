package com.jpacomparisions.store.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Pedido {
    private UUID id;
    private LocalDateTime dataPedido;
    private Pessoa pessoa;
}
