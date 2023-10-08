package com.jpacomparisions.store.adapters.primary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.PessoaDto;
import com.jpacomparisions.store.adapters.primary.dto.mappers.PessoaDtoMapper;
import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;
import com.jpacomparisions.store.application.PessoaService;

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

  public ResponseEntity<PessoaDto> novaPessoaFisica(@RequestBody PessoaDto pessoa) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapper.fromPessoaFisica(service.novaPessoaFisica(mapper.toPessoaFisica(pessoa))));
  }

  public ResponseEntity<PessoaDto> novaPessoaJuridica(@RequestBody PessoaDto pessoa) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapper.fromPessoaJuridica(service.novaPessoaJuridica(mapper.toPessoaJuridica(pessoa))));
  }

}
