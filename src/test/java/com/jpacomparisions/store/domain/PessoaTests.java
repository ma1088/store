package com.jpacomparisions.store.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaTests {
    @Test
    void buildPessoa() {
        String nome = "Alfredo Canis";
        LocalDate dataNascimento = LocalDate.of(2023, 2, 19);
        Pessoa pf = Pessoa.builder()
                .nome(nome)
                .data(dataNascimento)
                .build();
        assertEquals(nome, pf.getNome());
        assertEquals(dataNascimento, pf.getData());
    }

    @Test
    void newEmptyPessoa() {
        Pessoa pf = new Pessoa();
        assertNull(pf.getNome());
        assertNull(pf.getData());
    }

    @Test
    void newPessoa() {
        String nome = "Alfredo Canis";
        LocalDate dataNascimento = LocalDate.of(2023, 2, 19);
        Pessoa pf = new Pessoa(UUID.randomUUID(), nome, dataNascimento);
        assertEquals(nome, pf.getNome());
        assertEquals(dataNascimento, pf.getData());
        assertNotNull(pf.getId());
    }

    @Test
    void shouldChangePessoaNome() {
        String nome = "Alfredo Canis";
        Pessoa pf = new Pessoa();
        pf.setNome(nome);
        assertEquals(nome, pf.getNome());
    }

    @Test
    void shouldChangeAttributesFromSuper() {
        String nome = "Alfredo Canis";
        LocalDate dataNascimento = LocalDate.of(2023, 02, 19);
        Pessoa pf = Pessoa.builder()
                .nome(nome)
                .data(dataNascimento)
                .build();
        pf.setNome(nome + "!");
        pf.setData(dataNascimento.plusDays(1L));
        assertAll("grouped assertions of Pessoa",
                () -> assertEquals(pf.getNome(), nome + "!"),
                () -> assertEquals(pf.getData(), dataNascimento.plusDays(1L)));
    }
}
