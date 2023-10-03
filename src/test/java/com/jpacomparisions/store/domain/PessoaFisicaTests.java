package com.jpacomparisions.store.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaFisicaTests {
    @Test
    void buildPessoaFisica() {
        String cpf = "222.333.444-55";
        PessoaFisica pf = PessoaFisica.builder().cpf(cpf).build();
        assertEquals(cpf, pf.getCpf());
    }

    @Test
    void newEmptyPessoaFisica() {
        PessoaFisica pf = new PessoaFisica();
        assertNull(pf.getCpf());
    }

    @Test
    void newPessoaFisica() {
        String cpf = "222.333.444-55";
        PessoaFisica pf = new PessoaFisica(cpf);
        assertEquals(cpf, pf.getCpf());
    }

    @Test
    void shouldChangePessoaFisicaCpf() {
        String cpf = "222.333.444-55";
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf(cpf);
        assertEquals(cpf, pf.getCpf());
    }

    @Test
    void shouldChangeAttributesFromSuper() {
        String cpf = "222.333.444-55";
        String nome = "Alfredo Canis";
        LocalDate dataNascimento = LocalDate.of(2023, 02, 19);
        PessoaFisica pf = PessoaFisica.builder()
                .nome(nome)
                .data(dataNascimento)
                .cpf(cpf)
                .build();
        pf.setCpf(cpf + "!");
        pf.setNome(nome + "!");
        pf.setData(dataNascimento.plusDays(1L));
        assertAll("grouped assertions of Pessoa Fisica",
                () -> assertEquals(pf.getCpf(), cpf + "!"),
                () -> assertEquals(pf.getNome(), nome + "!"),
                () -> assertEquals(pf.getData(), dataNascimento.plusDays(1L)));
    }
}
