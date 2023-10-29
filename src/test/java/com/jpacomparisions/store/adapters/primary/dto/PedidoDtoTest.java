package com.jpacomparisions.store.adapters.primary.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;

@ExtendWith(MockitoExtension.class)
class PedidoDtoTest {
    @Test
    void test(){
        String id = UUID.randomUUID().toString();
        LocalDateTime dataPedido = LocalDateTime.now();
        PessoaDto pessoa = getPessoaDto();

        PedidoDto pedidoDto = new PedidoDto(id, dataPedido, pessoa, List.of());

        assertNotNull(pedidoDto);
        assertEquals(id, pedidoDto.getId());
        assertEquals(dataPedido, pedidoDto.getDataPedido());
        assertEquals(pessoa, pedidoDto.getPessoa());
        assert(pedidoDto.getProdutos()).isEmpty();
    }

    PessoaDto getPessoaDto(){
        return new PessoaDto(
            UUID.randomUUID().toString(), 
            "Alfredo", 
            LocalDate.of(2023,2,19), 
            TipoPessoaEnum.FISICA, 
            "222.333.444-55");
    }
}
