package com.jpacomparisions.store.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class PedidoProduto {
    @ManyToOne
    @JoinColumn
    private Pedido pedido;
    @ManyToOne
    @JoinColumn
    private Produto produto;
    @Column
    private Integer quantidade;
}
