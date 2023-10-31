package com.jpacomparisions.store.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jpacomparisions.store.adapters.secondary.PessoaRepository;
import com.jpacomparisions.store.domain.entities.Pessoa;
import com.jpacomparisions.store.domain.entities.PessoaFisica;
import com.jpacomparisions.store.domain.entities.PessoaJuridica;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository repository;

    public PessoaFisica novaPessoaFisica(PessoaFisica pessoaFisica) {
        return repository.saveAndFlush(pessoaFisica);
    }

    public PessoaJuridica novaPessoaJuridica(PessoaJuridica pessoaJuridica) {
        return repository.saveAndFlush(pessoaJuridica);
    }

    public List<Pessoa> recoverPessoa(Pessoa exemploPessoa) {
        return repository.findAll(Example.of(exemploPessoa));
    }

}
