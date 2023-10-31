package com.jpacomparisions.store.domain.settings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table
@SequenceGenerator(name = "sequence_generator", sequenceName = "seq_tipo_produto", allocationSize = 1)
@Data
@Builder
public class TipoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    Long id;
    @Column(length = 20)
    String nome;
    @Column(length = 500)
    String descricao;
}
