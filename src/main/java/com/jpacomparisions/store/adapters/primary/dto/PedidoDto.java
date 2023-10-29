package com.jpacomparisions.store.adapters.primary.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PedidoDto extends RepresentationModel<PedidoDto> {
    final String id;
    final LocalDateTime dataPedido;
    final PessoaDto pessoa;
    final List<ProdutoDto> produtos;

    @JsonCreator
    public PedidoDto(String id, LocalDateTime dataPedido, PessoaDto pessoa, List<ProdutoDto> produtos) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.pessoa = pessoa;
        this.produtos = produtos;
    }
}
