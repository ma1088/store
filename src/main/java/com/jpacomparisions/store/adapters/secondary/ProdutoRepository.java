package com.jpacomparisions.store.adapters.secondary;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpacomparisions.store.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    
}
