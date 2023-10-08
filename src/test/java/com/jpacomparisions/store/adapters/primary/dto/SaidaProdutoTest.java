package com.jpacomparisions.store.adapters.primary.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;

@ExtendWith(MockitoExtension.class)
public class SaidaProdutoTest {
    @Test
    void test(){
        String nomePessoa = "Juquinha S.A.";
        TipoPessoaEnum tipo = TipoPessoaEnum.JURIDICA;
        String numeroDocumento = "11.222.333/0001-44";
        String nomeProduto = "Pizza Margherita";
        String quantidade = "10";

        SaidaProdutoDto saidaProduto = new SaidaProdutoDto(nomePessoa, tipo, numeroDocumento, nomeProduto, quantidade);
        assertNotNull(saidaProduto);
        assertEquals(nomePessoa, saidaProduto.nomePessoa());
        assertEquals(tipo, saidaProduto.tipoPessoa());
        assertEquals(numeroDocumento, saidaProduto.numeroDocumento());
        assertEquals(nomeProduto, saidaProduto.nomeProduto());
        assertEquals(quantidade, saidaProduto.quantidadeProduto());
    }
}
