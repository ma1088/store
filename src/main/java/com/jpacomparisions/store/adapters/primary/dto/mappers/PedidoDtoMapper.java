package com.jpacomparisions.store.adapters.primary.dto.mappers;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.jpacomparisions.store.adapters.primary.dto.PedidoDto;
import com.jpacomparisions.store.adapters.primary.dto.PessoaDto;
import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;
import com.jpacomparisions.store.domain.Pedido;
import com.jpacomparisions.store.domain.Pessoa;
import com.jpacomparisions.store.domain.PessoaFisica;
import com.jpacomparisions.store.domain.PessoaJuridica;

@Mapper(componentModel = "spring")
public interface PedidoDtoMapper {
    @Mapping(target = "pessoa", source = "pessoa", qualifiedByName = "mapPessoaToPessoaDto")
    public PedidoDto fromPedido(Pedido pedido);

    @Mapping(target = "pessoa", source = "pessoa", qualifiedByName = "mapPessoaDtoToPessoa")
    public Pedido toPedido(PedidoDto pedidoDto);

    @Named("mapPessoaDtoToPessoa")
    default Pessoa map(PessoaDto pessoaDto) {
        if (pessoaDto.tipoPessoa().equals(TipoPessoaEnum.FISICA))
            return PessoaFisica.builder()
                    .id(UUID.fromString(pessoaDto.id()))
                    .nome(pessoaDto.nome())
                    .dataNascimento(pessoaDto.dtNascimento())
                    .cpf(pessoaDto.documento())
                    .build();
        return PessoaJuridica.builder()
                .id(UUID.fromString(pessoaDto.id()))
                .nome(pessoaDto.nome())
                .dataNascimento(pessoaDto.dtNascimento())
                .cnpj(pessoaDto.documento())
                .build();
    }

    @Named("mapPessoaToPessoaDto")
    default PessoaDto map(Pessoa pessoa) {
        if (pessoa instanceof PessoaFisica)
            return new PessoaDto(
                pessoa.getId().toString(), 
                pessoa.getNome(), 
                pessoa.getDataNascimento(), 
                TipoPessoaEnum.FISICA, 
                ((PessoaFisica)pessoa).getCpf());
        return new PessoaDto(
                pessoa.getId().toString(), 
                pessoa.getNome(), 
                pessoa.getDataNascimento(), 
                TipoPessoaEnum.JURIDICA, 
                ((PessoaJuridica)pessoa).getCnpj());
    }
}