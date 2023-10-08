package com.jpacomparisions.store.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProdutoTests {

    @Test
    void buildProdutoTest() {
        String descricao = "Pizza Margherita";
        UUID id = UUID.randomUUID();
        LocalDate validade = LocalDate.now().plusDays(3);

        Produto produto = Produto.builder()
                .id(id)
                .validade(validade)
                .descricao(descricao)
                .build();

        assertNotNull(produto);
        assertEquals(id, produto.getId());
        assertEquals(validade, produto.getValidade());
        assertEquals(descricao, produto.getDescricao());
    }

    @Test
    void constructProdutoAllArgs() {
        UUID id = UUID.randomUUID();
        LocalDate validade = LocalDate.now().plusDays(3);
        String descricao = "Pizza Margherita";

        Produto produto = new Produto(id, descricao, validade);

        assertNotNull(produto);
        assertEquals(id, produto.getId());
        assertEquals(validade, produto.getValidade());
        assertEquals(descricao, produto.getDescricao());
    }

    @Test
    void constructProdutoNoArgs() {
        Produto produto = new Produto();

        assertNotNull(produto);
        assertNull(produto.getId());
        assertNull(produto.getDescricao());
        assertNull(produto.getValidade());
    }

    @Test
    void testSetters() {
        UUID id = UUID.randomUUID();
        String descricao = "Pizza Margherita";
        LocalDate validade = LocalDate.now().plusDays(3);

        Produto produto = new Produto();

        assertNotNull(produto);

        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setValidade(validade);

        assertEquals(id, produto.getId());
        assertEquals(validade, produto.getValidade());
        assertEquals(descricao, produto.getDescricao());
    }

    @Test
    void testCanEqual() {
        String ref = UUID.randomUUID().toString();
        UUID id1 = UUID.fromString(ref);
        UUID id2 = UUID.fromString(ref);
        Produto produto1 = Produto.builder()
                .id(id1)
                .descricao("Pizza Margherita")
                .validade(LocalDate.now().plusDays(3))
                .build();
        Produto produto2 = Produto.builder()
                .id(id2)
                .descricao("Pizza Margherita")
                .validade(LocalDate.now().plusDays(3))
                .build();

        assertTrue(produto1.canEqual(produto2));
    }

    @Test
    void testToString() {
        Produto produto = Produto.builder()
                .id(UUID.fromString("c09694a9-02c6-46e6-9aaa-2daa48cd6324"))
                .descricao("Pizza Margherita")
                .validade(LocalDate.of(2023,10,11))
                .build();
        String produtoStr = produto.toString();
        String refString = "Produto(id=c09694a9-02c6-46e6-9aaa-2daa48cd6324, descricao=Pizza Margherita, validade=2023-10-11)";

        assertNotNull(produtoStr);
        assertEquals(refString, produtoStr);
    }

    @Test
    void testHashCode() {
        Produto produto = Produto.builder()
                .id(UUID.randomUUID())
                .descricao("Pizza Margherita")
                .validade(LocalDate.now().plusDays(3))
                .build();
        int hashCode1 = produto.hashCode();

        Produto produto2 = Produto.builder()
                .id(UUID.randomUUID())
                .descricao("Pizza Margherita")
                .validade(LocalDate.now().plusDays(3))
                .build();
        int hashCode2 = produto2.hashCode();

        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void testEquals() {
        Produto produto1 = Produto.builder()
                .id(UUID.randomUUID())
                .descricao("Pizza Margherita")
                .validade(LocalDate.now().plusDays(3))
                .build();

        Produto produto2 = Produto.builder()
                .id(UUID.randomUUID())
                .descricao("Pizza Margherita")
                .validade(LocalDate.now().plusDays(3))
                .build();

        assertNotEquals(produto1, produto2);
    }
}
