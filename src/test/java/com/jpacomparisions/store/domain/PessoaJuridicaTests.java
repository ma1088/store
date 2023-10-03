package com.jpacomparisions.store.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaJuridicaTests {
    @Test
    void buildPessoaJuridica() {
        String cnpj = "222.333.444-55";
        PessoaJuridica pf = PessoaJuridica.builder().cnpj(cnpj).build();
        assertEquals(cnpj, pf.getCnpj());
    }

    @Test
    void newEmptyPessoaJuridica() {
        PessoaJuridica pf = new PessoaJuridica();
        assertNull(pf.getCnpj());
    }

    @Test
    void newPessoaJuridica() {
        String cnpj = "222.333.444-55";
        PessoaJuridica pf = new PessoaJuridica(cnpj);
        assertEquals(cnpj, pf.getCnpj());
    }

    @Test
    void shouldChangePessoaJuridicaCpf() {
        String cnpj = "222.333.444-55";
        PessoaJuridica pf = new PessoaJuridica();
        pf.setCnpj(cnpj);
        assertEquals(cnpj, pf.getCnpj());
    }

    @Test
    void shouldChangeAttributesFromSuper() {
        String cnpj = "222.333.444-55";
        String nome = "Alfredo Canis";
        LocalDate dataNascimento = LocalDate.of(2023, 02, 19);
        PessoaJuridica pf = PessoaJuridica.builder()
                .nome(nome)
                .data(dataNascimento)
                .cnpj(cnpj)
                .build();
        pf.setCnpj(cnpj + "!");
        pf.setNome(nome + "!");
        pf.setData(dataNascimento.plusDays(1L));
        assertAll("grouped assertions of Pessoa Fisica",
                () -> assertEquals(pf.getCnpj(), cnpj + "!"),
                () -> assertEquals(pf.getNome(), nome + "!"),
                () -> assertEquals(pf.getData(), dataNascimento.plusDays(1L)));
    }
}
