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

import com.jpacomparisions.store.domain.entities.PessoaFisica;

@ExtendWith(MockitoExtension.class)
public class PessoaFisicaTests {

    @Test
    void buildPessoaFisicaTest() {
        UUID id = UUID.randomUUID();
        String nome = "Alfredo";
        LocalDate dataNascimento = LocalDate.of(2023, 1, 1);
        String cpf = "111.222.333-44";

        PessoaFisica pessoa = PessoaFisica.builder()
                .id(id)
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .build();

        assertNotNull(pessoa);
        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNascimento());
        assertEquals(cpf, pessoa.getCpf());
    }

    @Test
    void constructPessoaAllArgs() {
        UUID id = UUID.randomUUID();
        String nome = "Alfredo";
        LocalDate dataNascimento = LocalDate.of(2023, 1, 1);
        String cpf = "111.222.333-44";

        PessoaFisica pessoa = new PessoaFisica(id, nome, dataNascimento, cpf);

        assertNotNull(pessoa);
        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNascimento());
        assertEquals(cpf, pessoa.getCpf());
    }

    @Test
    void constructPessoaNoArgs() {
        PessoaFisica pessoa = new PessoaFisica();

        assertNotNull(pessoa);
        assertNull(pessoa.getId());
        assertNull(pessoa.getNome());
        assertNull(pessoa.getDataNascimento());
        assertNull(((PessoaFisica) pessoa).getCpf());
    }

    @Test
    void constructPessoaOneArg() {
        String cpf = "111.222.333-44";
        PessoaFisica pessoa = new PessoaFisica(cpf);
        assertNotNull(pessoa);
        assertEquals(cpf, pessoa.getCpf());
        assertNull(pessoa.getId());
        assertNull(pessoa.getNome());
        assertNull(pessoa.getDataNascimento());
    }

    @Test
    void testSetters() {
        UUID id = UUID.randomUUID();
        String nome = "Alfredo";
        LocalDate dataNascimento = LocalDate.of(2023, 1, 1);
        String cpf = "111.222.333-44";

        PessoaFisica pessoa = new PessoaFisica();
        assertNotNull(pessoa);

        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setDataNascimento(dataNascimento);
        pessoa.setCpf(cpf);

        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNascimento());
        assertEquals(cpf, pessoa.getCpf());
    }

    @Test
    void testCanEqual() {
        String ref = UUID.randomUUID().toString();
        UUID id1 = UUID.fromString(ref);
        UUID id2 = UUID.fromString(ref);
        PessoaFisica pessoa1 = PessoaFisica.builder()
                .id(id1)
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cpf("222.333.444-55")
                .build();
        PessoaFisica pessoa2 = PessoaFisica.builder()
                .id(id2)
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cpf("222.333.444-55")
                .build();

        assertTrue(pessoa1.canEqual(pessoa2));
    }

    @Test
    void testToString() {
        PessoaFisica pessoa = PessoaFisica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cpf("222.333.444-55")
                .build();
        String pessoaStr = pessoa.toString();
        String refString = "PessoaFisica(cpf=222.333.444-55)";

        assertNotNull(pessoaStr);
        assertEquals(refString, pessoaStr);
    }

    @Test
    void testHashCode() {
        PessoaFisica pessoa1 = PessoaFisica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cpf("222.333.444-55")
                .build();
        int hashCode1 = pessoa1.hashCode();

        PessoaFisica pessoa2 = PessoaFisica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cpf("222.333.444-55")
                .build();
        int hashCode2 = pessoa2.hashCode();

        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void testEquals() {
        PessoaFisica pessoa1 = PessoaFisica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cpf("222.333.444-55")
                .build();

        PessoaFisica pessoa2 = PessoaFisica.builder()
                .id(UUID.randomUUID())
                .nome("Alfredo")
                .dataNascimento(LocalDate.of(2023, 2, 19))
                .cpf("222.333.444-55")
                .build();

        assertNotEquals(pessoa1,pessoa2);
    }
}
