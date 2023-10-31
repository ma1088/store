package com.jpacomparisions.store.application;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.jpacomparisions.store.adapters.secondary.ProdutoRepository;
import com.jpacomparisions.store.domain.entities.Produto;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    private static final ExampleMatcher descriptionLikeCaseInsentitiveMatcher = ExampleMatcher.matchingAny()
            .withMatcher("descricao", GenericPropertyMatchers.contains().ignoreCase());

    public Produto createProduto(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> recoverProdutos() {
        return repository.findAll();
    }

    public List<Produto> recoverProdutos(Produto exemplo) {
        return repository.findAll(Example.of(exemplo, descriptionLikeCaseInsentitiveMatcher));
    }

    public Produto updateProduto(Produto novoProduto) {
        Produto produto = repository.findById(novoProduto.getId()).orElseThrow(() -> new ProdutoNotFoundException(
                String.format("Produto não encontrado com ID %s", novoProduto.getId())));
        produto.setDescricao(
                Objects.isNull(novoProduto.getDescricao()) ? produto.getDescricao() : novoProduto.getDescricao());
        produto.setValidade(
                Objects.isNull(novoProduto.getValidade()) ? produto.getValidade() : novoProduto.getValidade());
        return repository.save(produto);
    }

    public List<Produto> deleteProduto(Produto excluirProduto) {
        List<Produto> produtos = repository.findAll(Example.of(excluirProduto));
        if (!produtos.isEmpty()) {
            repository.deleteAllInBatch(produtos);
            return produtos;
        }

        Produto produto = Produto.builder()
                .descricao(excluirProduto.getDescricao())
                .validade(excluirProduto.getValidade())
                .build();
        produtos = repository.findAll(Example.of(produto, descriptionLikeCaseInsentitiveMatcher));

        if (produtos.isEmpty())
            throw new ProdutoNotFoundException(
                    String.format("Produto não encontrado com características %s", excluirProduto));
        repository.deleteAllInBatch(produtos);
        return produtos;
    }

}
