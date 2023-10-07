package com.jpacomparisions.store.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaFisicaTests {
    @Test
    public void buildPessoaFisicaTest() {
        UUID id = UUID.randomUUID();
        String nome = "Alfredo";
        LocalDate dataNascimento = LocalDate.of(2023, 1, 1);
        String cpf = "111.222.333-44";

        Pessoa pessoa = PessoaFisica.builder()
                .id(id)
                .nome(nome)
                .dataNacimento(dataNascimento)
                .cpf(cpf)
                .build();

        assertNotNull(pessoa);
        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNacimento());
        assertEquals(cpf, ((PessoaFisica) pessoa).getCpf());
    }

    @Test
    public void constructPessoaAllArgs() {
        UUID id = UUID.randomUUID();
        String nome = "Alfredo";
        LocalDate dataNascimento = LocalDate.of(2023, 1, 1);
        String cpf = "111.222.333-44";

        Pessoa pessoa = new PessoaFisica(id, nome, dataNascimento, cpf);

        assertNotNull(pessoa);
        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNacimento());
        assertEquals(cpf, ((PessoaFisica) pessoa).getCpf());
    }

    @Test
    public void constructPessoaNoArgs() {

    }
}
