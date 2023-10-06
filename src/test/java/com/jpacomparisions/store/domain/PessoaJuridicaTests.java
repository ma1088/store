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
        PessoaJuridica pj = PessoaJuridica.builder().cnpj(cnpj).build();
        assertEquals(cnpj, pj.getCnpj());
    }

    @Test
    void newEmptyPessoaJuridica() {
        PessoaJuridica pj = new PessoaJuridica();
        assertNull(pj.getCnpj());
    }

    @Test
    void newPessoaJuridica() {
        String cnpj = "222.333.444-55";
        Pessoa pessoa = Pessoa.builder()
                .nome("Canis Co.")
                .data(LocalDate.of(2023, 7, 1))
                .build();
        PessoaJuridica pj = new PessoaJuridica(pessoa, cnpj);
        assertEquals(cnpj, pj.getCnpj());
    }

    @Test
    void shouldChangePessoaJuridicaCpj() {
        String cnpj = "222.333.444-55";
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj(cnpj);
        assertEquals(cnpj, pj.getCnpj());
    }

    @Test
    void shouldChangeAttributesFromSuper() {
        String cnpj = "222.333.444-55";
        String nome = "Alfredo Canis";
        LocalDate dataNascimento = LocalDate.of(2023, 02, 19);
        PessoaJuridica pj = PessoaJuridica.builder()
                .pessoa(Pessoa.builder()
                        .nome(nome)
                        .data(dataNascimento)
                        .build())
                .cnpj(cnpj)
                .build();
        pj.setCnpj(cnpj + "!");
        pj.getPessoa().setNome(nome + "!");
        pj.getPessoa().setData(dataNascimento.plusDays(1L));
        assertAll("grouped assertions of Pessoa Juridica",
                () -> assertEquals(pj.getCnpj(), cnpj + "!"),
                () -> assertEquals(pj.getPessoa().getNome(), nome + "!"),
                () -> assertEquals(pj.getPessoa().getData(), dataNascimento.plusDays(1L)));
    }
}
