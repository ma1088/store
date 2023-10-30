package com.jpacomparisions.store.application;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jpacomparisions.store.adapters.secondary.ProdutoRepository;
import com.jpacomparisions.store.domain.Produto;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public Produto createProduto(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> recoverProdutos() {
        return repository.findAll();
    }

    public List<Produto> recoverProdutos(Produto exemplo) {
        return repository.findAll(Example.of(exemplo));
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

    public void deleteProduto(Produto excluirProduto) {
        Optional<Produto> produtoOptional = repository.findById(excluirProduto.getId());
        if (produtoOptional.isPresent()) {
            repository.delete(produtoOptional.get());
        } else {
            Produto produto = Produto.builder()
                    .descricao(excluirProduto.getDescricao())
                    .validade(excluirProduto.getValidade())
                    .build();
            List<Produto> produtos = repository.findAll(Example.of(produto));
            if (produtos.isEmpty())
                throw new ProdutoNotFoundException(
                        String.format("Produto não encontrado com características %s", excluirProduto));
            repository.deleteAllInBatch(produtos);
        }

    }

}
