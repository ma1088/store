package com.jpacomparisions.store.adapters.primary.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jpacomparisions.store.adapters.primary.dto.PessoaDto;
import com.jpacomparisions.store.adapters.primary.enums.TipoPessoaEnum;
import com.jpacomparisions.store.domain.Pessoa;
import com.jpacomparisions.store.domain.PessoaFisica;
import com.jpacomparisions.store.domain.PessoaJuridica;

@Mapper(componentModel = "spring")
public interface PessoaDtoMapper {
    @Mapping(target = "dtNascimento", source = "dataNascimento")
    @Mapping(target = "tipoPessoa", expression = "java(TipoPessoaEnum.FISICA)")
    @Mapping(target = "documento", source = "cpf")
    public PessoaDto fromPessoaFisica(PessoaFisica pessoaFisica);

    @Mapping(target = "dtNascimento", source = "dataNascimento")
    @Mapping(target = "tipoPessoa", expression = "java(TipoPessoaEnum.JURIDICA)")
    @Mapping(target = "documento", source = "cnpj")
    public PessoaDto fromPessoaJuridica(PessoaJuridica pessoaJuridica);

    @Mapping(target = "dataNascimento", source = "dtNascimento")
    @Mapping(target = "cpf", source = "documento")
    public PessoaFisica toPessoaFisica(PessoaDto pessoaDto);

    @Mapping(target = "dataNascimento", source = "dtNascimento")
    @Mapping(target = "cnpj", source = "documento")
    public PessoaJuridica toPessoaJuridica(PessoaDto pessoaDto);

    public default Pessoa getPessoa(PessoaDto pessoaDto) {
        if (pessoaDto.tipoPessoa().equals(TipoPessoaEnum.FISICA))
            return toPessoaFisica(pessoaDto);
        return toPessoaJuridica(pessoaDto);
    }
}
