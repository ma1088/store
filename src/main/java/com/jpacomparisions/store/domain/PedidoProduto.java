package com.jpacomparisions.store.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoProduto {
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;
}
