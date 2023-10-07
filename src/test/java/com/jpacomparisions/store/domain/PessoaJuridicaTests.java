package com.jpacomparisions.store.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaJuridicaTests {
    @Test
    void buildPessoaJuridica() {
        String cnpj = "222.333.444-55";
        PessoaJuridica pj = PessoaJuridica.builder().cnpj(cnpj).build();
        assertEquals(cnpj, pj.getCnpj());
    }

    @Test
    void newEmptyPessoaJuridica() {
        PessoaJuridica pj = new PessoaJuridica();
        assertNull(pj.getCnpj());
    }

    @Test
    void shouldChangePessoaJuridicaCpj() {
        String cnpj = "222.333.444-55";
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj(cnpj);
        assertEquals(cnpj, pj.getCnpj());
    }
}
