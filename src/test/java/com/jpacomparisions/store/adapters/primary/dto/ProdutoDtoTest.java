package com.jpacomparisions.store.adapters.primary.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProdutoDtoTest {
    @Test
    void test(){
        String id = "oi, tudo bem?";
        String descricao = "Pizza Margherita";
        LocalDate validade = LocalDate.now().plusDays(3);

        ProdutoDto produto = new ProdutoDto(id, descricao, validade);
        
        assertNotNull(produto);
        assertEquals(id, produto.id());
        assertEquals(descricao, produto.descricao());
        assertEquals(validade, produto.validade());

        
    }
}
