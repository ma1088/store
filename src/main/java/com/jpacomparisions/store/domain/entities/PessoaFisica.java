package com.jpacomparisions.store.domain.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("FISICA")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor 
@NoArgsConstructor
@SuperBuilder
@Data
public class PessoaFisica extends Pessoa{
    public PessoaFisica(UUID id, String nome, LocalDate dataNascimento, String cpf) {
        super(id, nome, dataNascimento);
        setCpf(cpf);
    }

    @Column
    private String cpf;
}
