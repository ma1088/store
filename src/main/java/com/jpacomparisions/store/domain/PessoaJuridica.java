package com.jpacomparisions.store.domain;

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
@DiscriminatorValue("JURIDICA")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class PessoaJuridica extends Pessoa {
    public PessoaJuridica(UUID id, String nome, LocalDate dataNascimento, String cnpj) {
        super(id, nome, dataNascimento);
        setCnpj(cnpj);
    }

    @Column
    private String cnpj;
}
