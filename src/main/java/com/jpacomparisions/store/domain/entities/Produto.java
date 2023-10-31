package com.jpacomparisions.store.domain.entities;

import java.time.LocalDate;
import java.util.UUID;

import com.jpacomparisions.store.domain.settings.TipoProduto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Produto {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String descricao;
    @Column
    private LocalDate validade;
    @JoinColumn
    @ManyToOne(targetEntity = TipoProduto.class, fetch = FetchType.LAZY)
    TipoProduto tipoProduto;
}
