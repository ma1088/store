package com.jpacomparisions.store.adapters.primary.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoDto extends RepresentationModel<ProdutoDto> {
    String id;
    String descricao;
    LocalDate validade;
}
