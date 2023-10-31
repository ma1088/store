package com.jpacomparisions.store.domain.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table
public class PedidoProduto {
    @Id
    @GeneratedValue
    UUID id;
    @ManyToOne
    @JoinColumn
    private Pedido pedido;
    @ManyToOne
    @JoinColumn
    private Produto produto;
    @Column
    private Integer quantidade;
}
