package com.jpacomparisions.store.adapters.primary.dto.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.jpacomparisions.store.adapters.primary.dto.PedidoDto;
import com.jpacomparisions.store.adapters.primary.dto.PessoaDto;
import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;
import com.jpacomparisions.store.domain.entities.Pedido;
import com.jpacomparisions.store.domain.entities.Pessoa;
import com.jpacomparisions.store.domain.entities.PessoaFisica;
import com.jpacomparisions.store.domain.entities.PessoaJuridica;

@Mapper(componentModel = "spring")
public interface PedidoDtoMapper {
    @Mapping(target = "pessoa", source = "pessoa", qualifiedByName = "mapPessoaToPessoaDto")
    @Mapping(target = "add", ignore = true)
    @Mapping(target = "produtos", ignore = true)
    public PedidoDto fromPedido(Pedido pedido);

    public List<PedidoDto> fromPedido(List<Pedido> pedido);

    @Mapping(target = "pessoa", source = "pessoa", qualifiedByName = "mapPessoaDtoToPessoa")
    public Pedido toPedido(PedidoDto pedidoDto);

    @Named("mapPessoaDtoToPessoa")
    default Pessoa map(PessoaDto pessoaDto) {
        if (pessoaDto.getTipoPessoa().equals(TipoPessoaEnum.FISICA))
            return PessoaFisica.builder()
                    .id(UUID.fromString(pessoaDto.getId()))
                    .nome(pessoaDto.getNome())
                    .dataNascimento(pessoaDto.getDtNascimento())
                    .cpf(pessoaDto.getDocumento())
                    .build();
        return PessoaJuridica.builder()
                .id(UUID.fromString(pessoaDto.getId()))
                .nome(pessoaDto.getNome())
                .dataNascimento(pessoaDto.getDtNascimento())
                .cnpj(pessoaDto.getDocumento())
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
