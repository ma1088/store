package com.jpacomparisions.store.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jpacomparisions.store.domain.entities.Pedido;
import com.jpacomparisions.store.domain.entities.PedidoProduto;
import com.jpacomparisions.store.domain.entities.Pessoa;
import com.jpacomparisions.store.domain.entities.PessoaFisica;
import com.jpacomparisions.store.domain.entities.Produto;
import com.jpacomparisions.store.domain.settings.TipoProduto;

@ExtendWith(MockitoExtension.class)
class PedidoProdutoTests {

    @Test
    void buildPedidoTest() {
        UUID id = UUID.randomUUID();
        Pedido pedido = getPedido();
        Produto produto = getProduto();
        Integer quantidade = 9;

        PedidoProduto pedidoProduto = PedidoProduto.builder()
                .id(id)
                .pedido(pedido)
                .produto(produto)
                .quantidade(quantidade)
                .build();

        assertNotNull(pedido);
        assertEquals(id, pedidoProduto.getId());
        assertEquals(produto, pedidoProduto.getProduto());
        assertEquals(pedido, pedidoProduto.getPedido());
        assertEquals(quantidade, pedidoProduto.getQuantidade());
    }

    @Test
    void constructPedidoAllArgs() {
        UUID id = UUID.randomUUID();
        Pedido pedido = getPedido();
        Produto produto = getProduto();
        Integer quantidade = 9;

        PedidoProduto pedidoProduto = new PedidoProduto(id, pedido, produto, quantidade);

        assertNotNull(pedido);
        assertEquals(id, pedidoProduto.getId());
        assertEquals(produto, pedidoProduto.getProduto());
        assertEquals(pedido, pedidoProduto.getPedido());
        assertEquals(quantidade, pedidoProduto.getQuantidade());
    }

    @Test
    void constructPedidoNoArgs() {
        PedidoProduto pedidoProduto = new PedidoProduto();

        assertNotNull(pedidoProduto);
        assertNull(pedidoProduto.getId());
        assertNull(pedidoProduto.getPedido());
        assertNull(pedidoProduto.getProduto());
        assertNull(pedidoProduto.getQuantidade());
    }

    @Test
    void testSetters() {
        UUID id = UUID.randomUUID();
        Produto produto = getProduto();
        Pedido pedido = getPedido();
        Integer quantidade = 9;

        PedidoProduto pedidoProduto = new PedidoProduto();

        assertNotNull(pedidoProduto);

        pedidoProduto.setId(id);
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setProduto(produto);
        pedidoProduto.setQuantidade(quantidade);

        assertEquals(id, pedidoProduto.getId());
        assertEquals(produto, pedidoProduto.getProduto());
        assertEquals(pedido, pedidoProduto.getPedido());
        assertEquals(quantidade, pedidoProduto.getQuantidade());
    }

    @Test
    void testCanEqual() {
        String ref = UUID.randomUUID().toString();
        UUID id1 = UUID.fromString(ref);
        UUID id2 = UUID.fromString(ref);

        PedidoProduto pedidoProduto1 = PedidoProduto.builder()
                .id(id1)
                .pedido(getPedido())
                .produto(getProduto())
                .quantidade(8)
                .build();
        PedidoProduto pedidoProduto2 = PedidoProduto.builder()
                .id(id2)
                .pedido(getPedido())
                .produto(getProduto())
                .quantidade(8)
                .build();

        assertEquals(pedidoProduto1.toString(), pedidoProduto2.toString());
    }

    @Test
    void testToString() {
        PedidoProduto pedidoProduto = PedidoProduto.builder()
                .id(UUID.fromString("c09694a9-02c6-46e6-9aaa-2daa48cd6324"))
                .pedido(getPedido())
                .produto(getProduto())
                .quantidade(9)
                .build();
        String pedidoProdutoStr = pedidoProduto.toString();
        String refString = "PedidoProduto(id=c09694a9-02c6-46e6-9aaa-2daa48cd6324, pedido=Pedido(id=b9976434-13f0-4159-97f3-7649cad0e572, dataPedido=2023-10-08T01:08, pessoa=PessoaFisica(cpf=222.333.444-55)), produto=Produto(id=ca295fc0-69b9-46c8-a093-f066dd34acb7, descricao=Pizza Margherita, validade=2023-11-01, tipoProduto=TipoProduto(id=1, nome=Pizza, descricao=Massa moldada em forma de disco com recheio em cima. Pode ser doce ou salgada.)), quantidade=9)";

        assertNotNull(pedidoProdutoStr);
        assertEquals(refString, pedidoProdutoStr);
    }

    @Test
    void testHashCode() {
        PedidoProduto pedidoProduto1 = PedidoProduto.builder()
                .id(UUID.randomUUID())
                .pedido(getPedido())
                .produto(getProduto())
                .quantidade(8)
                .build();
        PedidoProduto pedidoProduto2 = PedidoProduto.builder()
                .id(UUID.randomUUID())
                .pedido(getPedido())
                .produto(getProduto())
                .quantidade(8)
                .build();
        int hashCode1 = pedidoProduto1.hashCode();
        int hashCode2 = pedidoProduto2.hashCode();

        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void testEquals() {
        Pedido pedido1 = Pedido.builder()
                .id(UUID.randomUUID())
                .pessoa(getPessoa())
                .dataPedido(LocalDateTime.now())
                .build();

        Pedido pedido2 = Pedido.builder()
                .id(UUID.randomUUID())
                .pessoa(getPessoa())
                .dataPedido(LocalDateTime.now())
                .build();

        assertNotEquals(pedido1, pedido2);
    }

    Pessoa getPessoa() {
        return PessoaFisica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cpf("222.333.444-55")
                .build();
    }

    private Produto getProduto() {
        String refIdStr = "ca295fc0-69b9-46c8-a093-f066dd34acb7";

        TipoProduto tipoProduto = new TipoProduto(1L,
                "Pizza",
                "Massa moldada em forma de disco com recheio em cima. Pode ser doce ou salgada.");
        return Produto.builder()
                .id(UUID.fromString(refIdStr))
                .validade(LocalDate.of(2023, 11, 01))
                .descricao("Pizza Margherita")
                .tipoProduto(tipoProduto)
                .build();
    }

    private Pedido getPedido() {
        String refIdStr = "b9976434-13f0-4159-97f3-7649cad0e572";
        return Pedido.builder()
                .id(UUID.fromString(refIdStr))
                .pessoa(getPessoa())
                .dataPedido(LocalDateTime.of(2023, 10, 8, 1, 8, 0))
                .build();
    }
}
