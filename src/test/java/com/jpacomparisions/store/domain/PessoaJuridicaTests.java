package com.jpacomparisions.store.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jpacomparisions.store.domain.entities.PessoaJuridica;

@ExtendWith(MockitoExtension.class)
public class PessoaJuridicaTests {

    @Test
    void buildPessoaJuridicaTest() {
        UUID id = UUID.randomUUID();
        String nome = "Alfredo";
        LocalDate dataNascimento = LocalDate.of(2023, 1, 1);
        String cnpj = "111.222.333-44";

        PessoaJuridica pessoa = PessoaJuridica.builder()
                .id(id)
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cnpj(cnpj)
                .build();

        assertNotNull(pessoa);
        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNascimento());
        assertEquals(cnpj, pessoa.getCnpj());
    }

    @Test
    void constructPessoaAllArgs() {
        UUID id = UUID.randomUUID();
        String nome = "Alfredo";
        LocalDate dataNascimento = LocalDate.of(2023, 1, 1);
        String cnpj = "111.222.333-44";

        PessoaJuridica pessoa = new PessoaJuridica(id, nome, dataNascimento, cnpj);

        assertNotNull(pessoa);
        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNascimento());
        assertEquals(cnpj, pessoa.getCnpj());
    }

    @Test
    void constructPessoaNoArgs() {
        PessoaJuridica pessoa = new PessoaJuridica();

        assertNotNull(pessoa);
        assertNull(pessoa.getId());
        assertNull(pessoa.getNome());
        assertNull(pessoa.getDataNascimento());
        assertNull(((PessoaJuridica) pessoa).getCnpj());
    }

    @Test
    void constructPessoaOneArg() {
        String cnpj = "111.222.333-44";
        PessoaJuridica pessoa = new PessoaJuridica(cnpj);
        assertNotNull(pessoa);
        assertEquals(cnpj, pessoa.getCnpj());
        assertNull(pessoa.getId());
        assertNull(pessoa.getNome());
        assertNull(pessoa.getDataNascimento());
    }

    @Test
    void testSetters() {
        UUID id = UUID.randomUUID();
        String nome = "Alfredo";
        LocalDate dataNascimento = LocalDate.of(2023, 1, 1);
        String cnpj = "111.222.333-44";

        PessoaJuridica pessoa = new PessoaJuridica();
        assertNotNull(pessoa);

        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setDataNascimento(dataNascimento);
        pessoa.setCnpj(cnpj);

        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNascimento());
        assertEquals(cnpj, pessoa.getCnpj());
    }

    @Test
    void testCanEqual() {
        String ref = UUID.randomUUID().toString();
        UUID id1 = UUID.fromString(ref);
        UUID id2 = UUID.fromString(ref);
        PessoaJuridica pessoa1 = PessoaJuridica.builder()
                .id(id1)
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cnpj("222.333.444-55")
                .build();
        PessoaJuridica pessoa2 = PessoaJuridica.builder()
                .id(id2)
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cnpj("222.333.444-55")
                .build();

        assertTrue(pessoa1.canEqual(pessoa2));
    }

    @Test
    void testToString() {
        PessoaJuridica pessoa = PessoaJuridica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cnpj("222.333.444-55")
                .build();
        String pessoaStr = pessoa.toString();
        String refString = "PessoaJuridica(cnpj=222.333.444-55)";

        assertNotNull(pessoaStr);
        assertEquals(refString, pessoaStr);
    }

    @Test
    void testHashCode() {
        PessoaJuridica pessoa1 = PessoaJuridica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cnpj("222.333.444-55")
                .build();
        int hashCode1 = pessoa1.hashCode();

        PessoaJuridica pessoa2 = PessoaJuridica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cnpj("222.333.444-55")
                .build();
        int hashCode2 = pessoa2.hashCode();

        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void testEquals() {
        PessoaJuridica pessoa1 = PessoaJuridica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cnpj("222.333.444-55")
                .build();

        PessoaJuridica pessoa2 = PessoaJuridica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cnpj("222.333.444-55")
                .build();

        assertNotEquals(pessoa1,pessoa2);
    }
}
