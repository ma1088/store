package com.jpacomparisions.store.adapters.primary.dto;

import java.time.LocalDate;

public record ProdutoDto(
    String id,
    String descricao, 
    LocalDate validade) {

}
