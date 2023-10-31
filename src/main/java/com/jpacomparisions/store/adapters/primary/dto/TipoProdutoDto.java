package com.jpacomparisions.store.adapters.primary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class TipoProdutoDto{
    String nome;
    String descricao;
}
