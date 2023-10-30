package com.jpacomparisions.store.adapters.primary.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    PessoaDto pessoaDto = null;
    if (pessoa.getTipoPessoa().equals(TipoPessoaEnum.FISICA)) {
      pessoaDto = novaPessoaFisica(pessoa);
    } else {
      pessoaDto = novaPessoaJuridica(pessoa);
    }

    addSelfRel(pessoaDto, pessoaDto.getId());

    return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);
  }

  @GetMapping
  public ResponseEntity<List<PessoaDto>> getPessoa(@RequestParam UUID id, @RequestBody PessoaDto exemplo) {
    Pessoa exemploPessoa = new Pessoa() {
    };
    if (exemplo.getTipoPessoa().equals(TipoPessoaEnum.FISICA))
      exemploPessoa = mapper.toPessoaFisica(exemplo);
    if (exemplo.getTipoPessoa().equals(TipoPessoaEnum.JURIDICA))
      exemploPessoa = mapper.toPessoaJuridica(exemplo);
    exemploPessoa.setId(id);
    
    List<PessoaDto> pessoas = mapper.fromPessoa(service.recoverPessoa(exemploPessoa));

    pessoas.forEach(item -> addSelfRel(item, item.getId()));

    return ResponseEntity.ok().body(pessoas);

  }

  public PessoaDto novaPessoaFisica(@RequestBody PessoaDto pessoa) {
    return mapper.fromPessoaFisica(service.novaPessoaFisica(mapper.toPessoaFisica(pessoa)));
  }

  public PessoaDto novaPessoaJuridica(@RequestBody PessoaDto pessoa) {
    return mapper.fromPessoaJuridica(service.novaPessoaJuridica(mapper.toPessoaJuridica(pessoa)));
  }

  void addSelfRel(RepresentationModel<?> responseBody, String uuid) {
    responseBody.add(
        linkTo(methodOn(PessoaController.class).getPessoa(UUID.fromString(uuid), null))
            .withSelfRel());
  }
}
