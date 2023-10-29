package com.jpacomparisions.store.adapters.primary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.PessoaDto;
import com.jpacomparisions.store.adapters.primary.dto.mappers.PessoaDtoMapper;
import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;
import com.jpacomparisions.store.application.PessoaService;
import com.jpacomparisions.store.domain.Pessoa;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
  @Autowired
  PessoaService service;
  @Autowired
  PessoaDtoMapper mapper;

  @PostMapping
  public ResponseEntity<PessoaDto> novaPessoa(@RequestBody PessoaDto pessoa) {
    if (pessoa.tipoPessoa().equals(TipoPessoaEnum.FISICA))
      return novaPessoaFisica(pessoa);
    return novaPessoaJuridica(pessoa);
  }

  @GetMapping
  public ResponseEntity<List<PessoaDto>> getPessoa(@RequestBody PessoaDto exemplo){
    Pessoa exemploPessoa = new Pessoa() {};
    if (exemplo.tipoPessoa().equals(TipoPessoaEnum.FISICA)) exemploPessoa =mapper.toPessoaFisica(exemplo);
    if (exemplo.tipoPessoa().equals(TipoPessoaEnum.JURIDICA)) exemploPessoa = mapper.toPessoaJuridica(exemplo);
    return ResponseEntity.ok().body(mapper.fromPessoa(service.recoverPessoa(exemploPessoa)));
    
  }

  public ResponseEntity<PessoaDto> novaPessoaFisica(@RequestBody PessoaDto pessoa) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapper.fromPessoaFisica(service.novaPessoaFisica(mapper.toPessoaFisica(pessoa))));
  }

  public ResponseEntity<PessoaDto> novaPessoaJuridica(@RequestBody PessoaDto pessoa) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapper.fromPessoaJuridica(service.novaPessoaJuridica(mapper.toPessoaJuridica(pessoa))));
  }

}
