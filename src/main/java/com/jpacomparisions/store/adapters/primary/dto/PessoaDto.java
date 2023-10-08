package com.jpacomparisions.store.adapters.primary.dto;

import java.time.LocalDate;

public record PessoaDto(
    String id,
    String nome,
    LocalDate dtNascimento,
    String tipoPessoa,
    String documento
) {
    
}
