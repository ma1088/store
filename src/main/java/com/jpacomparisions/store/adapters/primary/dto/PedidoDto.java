package com.jpacomparisions.store.adapters.primary.dto;

import java.time.LocalDateTime;

public record PedidoDto (
    String id,
    LocalDateTime dataPedido,
    PessoaDto pessoa
) {

}
