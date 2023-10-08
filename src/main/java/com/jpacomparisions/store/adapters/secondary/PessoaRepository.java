package com.jpacomparisions.store.adapters.secondary;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpacomparisions.store.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    
}
