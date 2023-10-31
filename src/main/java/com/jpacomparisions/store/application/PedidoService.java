package com.jpacomparisions.store.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jpacomparisions.store.adapters.secondary.PedidoRepository;
import com.jpacomparisions.store.domain.entities.Pedido;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository repository;

    public Pedido createPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public List<Pedido> recoverPedidos(Pedido exemplo) {
        return repository.findAll(Example.of(exemplo));
    }

}
