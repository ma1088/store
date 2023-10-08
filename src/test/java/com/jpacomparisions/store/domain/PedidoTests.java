package com.jpacomparisions.store.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PedidoTests {

    @Test
    void buildPedidoTest() {
        Pessoa pessoa = getPessoa();
        UUID id = UUID.randomUUID();
        LocalDateTime dataPedido = LocalDateTime.now();

        Pedido pedido = Pedido.builder()
                .id(id)
                .dataPedido(dataPedido)
                .pessoa(pessoa)
                .build();

        assertNotNull(pedido);
        assertEquals(id, pedido.getId());
        assertEquals(dataPedido, pedido.getDataPedido());
        assertEquals(pessoa, pedido.getPessoa());
    }

    @Test
    void constructPedidoAllArgs() {
        UUID id = UUID.randomUUID();
        LocalDateTime dataPedido = LocalDateTime.now();
        Pessoa pessoa = getPessoa();

        Pedido pedido = new Pedido(id, dataPedido, pessoa);

        assertNotNull(pedido);
        assertEquals(id, pedido.getId());
        assertEquals(dataPedido, pedido.getDataPedido());
        assertEquals(pessoa, pedido.getPessoa());
    }

    @Test
    void constructPedidoNoArgs() {
        Pedido pedido = new Pedido();

        assertNotNull(pedido);
        assertNull(pedido.getId());
        assertNull(pedido.getPessoa());
        assertNull(pedido.getDataPedido());
    }

    @Test
    void testSetters() {
        UUID id = UUID.randomUUID();
        Pessoa pessoa = getPessoa();
        LocalDateTime dataPedido = LocalDateTime.now();

        Pedido pedido = new Pedido();

        assertNotNull(pedido);

        pedido.setId(id);
        pedido.setPessoa(pessoa);
        pedido.setDataPedido(dataPedido);

        assertEquals(id, pedido.getId());
        assertEquals(dataPedido, pedido.getDataPedido());
        assertEquals(pessoa, pedido.getPessoa());
    }

    @Test
    void testCanEqual() {
        String ref = UUID.randomUUID().toString();
        UUID id1 = UUID.fromString(ref);
        UUID id2 = UUID.fromString(ref);
        Pedido pedido1 = Pedido.builder()
                .id(id1)
                .pessoa(getPessoa())
                .dataPedido(LocalDateTime.now())
                .build();
        Pedido pedido2 = Pedido.builder()
                .id(id2)
                .pessoa(getPessoa())
                .dataPedido(LocalDateTime.now())
                .build();

        assertTrue(pedido1.canEqual(pedido2));
    }

    @Test
    void testToString() {
        Pedido pedido = Pedido.builder()
                .id(UUID.fromString("c09694a9-02c6-46e6-9aaa-2daa48cd6324"))
                .pessoa(getPessoa())
                .dataPedido(LocalDateTime.of(2023,10,8,0,26,0))
                .build();
        String pedidoStr = pedido.toString();
        String refString = "Pedido(id=c09694a9-02c6-46e6-9aaa-2daa48cd6324, dataPedido=2023-10-08T00:26, pessoa=PessoaFisica(cpf=222.333.444-55))";

        assertNotNull(pedidoStr);
        assertEquals(refString, pedidoStr);
    }

    @Test
    void testHashCode() {
        Pedido pedido = Pedido.builder()
                .id(UUID.randomUUID())
                .pessoa(getPessoa())
                .dataPedido(LocalDateTime.now())
                .build();
        int hashCode1 = pedido.hashCode();

        Pedido pedido2 = Pedido.builder()
                .id(UUID.randomUUID())
                .pessoa(getPessoa())
                .dataPedido(LocalDateTime.now())
                .build();
        int hashCode2 = pedido2.hashCode();

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
                .dataNascimento(LocalDate.of(2023,2,19))
                .cpf("222.333.444-55")
                .build();
    }
}
