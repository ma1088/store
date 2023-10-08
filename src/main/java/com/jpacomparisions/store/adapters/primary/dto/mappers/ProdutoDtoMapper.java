package com.jpacomparisions.store.adapters.primary.dto.mappers;

import org.mapstruct.Mapper;

import com.jpacomparisions.store.adapters.primary.dto.ProdutoDto;
import com.jpacomparisions.store.domain.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoDtoMapper {
    public ProdutoDto fromProduto(Produto produto);

    public Produto toProduto(ProdutoDto produtoDto);
}
