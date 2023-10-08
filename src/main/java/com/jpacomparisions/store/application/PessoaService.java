package com.jpacomparisions.store.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpacomparisions.store.adapters.secondary.PessoaRepository;
import com.jpacomparisions.store.domain.PessoaFisica;
import com.jpacomparisions.store.domain.PessoaJuridica;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository repository;

    public PessoaFisica novaPessoaFisica(PessoaFisica pessoaFisica) {
        return repository.saveAndFlush(pessoaFisica);
    }

    public PessoaJuridica novaPessoaJuridica(PessoaJuridica PessoaJuridica) {
        return repository.saveAndFlush(PessoaJuridica);
    }

}
