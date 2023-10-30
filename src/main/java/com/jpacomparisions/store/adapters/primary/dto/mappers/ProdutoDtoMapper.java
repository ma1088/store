package com.jpacomparisions.store.adapters.primary.dto.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jpacomparisions.store.adapters.primary.dto.ProdutoDto;
import com.jpacomparisions.store.domain.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoDtoMapper {
    @Mapping(target = "add", ignore = true)
    public ProdutoDto fromProduto(Produto produto);

    public Produto toProduto(ProdutoDto produtoDto);

    public List<ProdutoDto> fromProduto(List<Produto> recoverProdutos);
}
