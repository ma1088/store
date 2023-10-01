package com.jpacomparisions.store.adapters.primary.dto;

import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;

public record SaidaProdutoDto(
    String nomePessoa,
    TipoPessoaEnum tipoPessoa,
    String numeroDocumento,
    String nomeProduto,
    String quantidadeProduto
) {
    
}
