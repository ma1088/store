package com.jpacomparisions.store.adapters.primary.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PessoaDto extends RepresentationModel<PessoaDto> {
    String id;
    String nome;
    LocalDate dtNascimento;
    TipoPessoaEnum tipoPessoa;
    String documento;
}
