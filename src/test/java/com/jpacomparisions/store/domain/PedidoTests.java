package com.jpacomparisions.store.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PedidoTests {
    @Test
    public void buildPedidoTest() {
        UUID id = UUID.randomUUID();
        LocalDateTime dataPedido = LocalDateTime.of(2023, 7, 1, 20, 0, 0);
        PessoaFisica pessoa = getPessoa();

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
    public void constructPedidoTest() {
        UUID id = UUID.randomUUID();
        LocalDateTime dataPedido = LocalDateTime.of(2023, 7, 1, 20, 0, 0);
        PessoaFisica pessoa = getPessoa();

        Pedido pedido = new Pedido(id, dataPedido, pessoa);

        assertNotNull(pedido);
        assertEquals(id, pedido.getId());
        assertEquals(dataPedido, pedido.getDataPedido());
        assertEquals(pessoa, pedido.getPessoa());
    }

    @Test
    public void constructPedidoNoArgsTest() {
        Pedido pedido = new Pedido();

        assertNull(pedido.getId());
        assertNull(pedido.getDataPedido());
        assertNull(pedido.getPessoa());
    }

    @Test
    public void setAttributesTest() {
        UUID id = UUID.randomUUID();
        LocalDateTime dataPedido = LocalDateTime.of(2023, 7, 1, 20, 0, 0);
        PessoaFisica pessoa = getPessoa();

        Pedido pedido = new Pedido();

        pedido.setId(id);
        pedido.setDataPedido(dataPedido);
        pedido.setPessoa(pessoa);

        assertNotNull(pedido);
        assertEquals(id, pedido.getId());
        assertEquals(dataPedido, pedido.getDataPedido());
        assertEquals(pessoa, pedido.getPessoa());

    }

    private PessoaFisica getPessoa() {
        return PessoaFisica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNacimento(LocalDate.of(2023, 2, 19))
                .cpf("123.456.789-10")
                .build();
    }

}
