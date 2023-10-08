package com.jpacomparisions.store.adapters.primary.dto;

import java.time.LocalDate;

import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;

public record PessoaDto(
    String id,
    String nome,
    LocalDate dtNascimento,
    TipoPessoaEnum tipoPessoa,
    String documento
) {
    
}
