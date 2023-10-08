package com.jpacomparisions.store.adapters.primary.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;

@ExtendWith(MockitoExtension.class)
public class PessoaDtoTest {
    @Test
    void test(){
        String id = UUID.randomUUID().toString();
        String nome = "Alfredo";
        LocalDate dtNascimento = LocalDate.of(2023,2,19);
        TipoPessoaEnum tipoPessoa = TipoPessoaEnum.FISICA;
        String documento = "222.333.444-55";

        PessoaDto pessoa = new PessoaDto(
            id, 
            nome, 
            dtNascimento, 
            tipoPessoa, 
            documento);
        assertNotNull(pessoa);
        assertEquals(id, pessoa.id());
        assertEquals(nome, pessoa.nome());
        assertEquals(dtNascimento, pessoa.dtNascimento());
        assertEquals(tipoPessoa, pessoa.tipoPessoa());
        assertEquals(documento, pessoa.documento());
        
        
    }
}
