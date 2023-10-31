package com.jpacomparisions.store.adapters.secondary;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpacomparisions.store.domain.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    
}
