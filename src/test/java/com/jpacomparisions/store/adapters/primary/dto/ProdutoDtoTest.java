package com.jpacomparisions.store.adapters.primary.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProdutoDtoTest {
    @Test
    void test() {
        String id = "oi, tudo bem?";
        String descricao = "Pizza Margherita";
        LocalDate validade = LocalDate.now().plusDays(3);
        TipoProdutoDto tipoProdutoDto = new TipoProdutoDto(
                "Pizza",
                "Massa modelada em forma de disco com algum recheio por cima. Pode ser doce ou salgada.");

        ProdutoDto produto = new ProdutoDto(id, descricao, validade, tipoProdutoDto);

        assertNotNull(produto);
        assertEquals(id, produto.getId());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(validade, produto.getValidade());
        assertEquals(tipoProdutoDto, produto.getTipoProduto());
    }
}
