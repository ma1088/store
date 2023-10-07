package com.jpacomparisions.store;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpacomparisions.store.adapters.primary.PedidoController;
import com.jpacomparisions.store.adapters.primary.PessoaController;
import com.jpacomparisions.store.adapters.primary.ProdutoController;
import com.jpacomparisions.store.application.PedidoService;
import com.jpacomparisions.store.application.PessoaService;
import com.jpacomparisions.store.application.ProdutoService;

@SpringBootTest
class StoreApplicationTests {
	@Autowired
	PedidoController pedidoController;
	@Autowired
	PessoaController pessoaController;
	@Autowired
	ProdutoController produtoController;

	@Autowired
	PedidoService pedidoService;
	@Autowired
	PessoaService pessoaService;
	@Autowired
	ProdutoService produtoService;

	@Test
	void contextLoads() {
		assertNotNull(pedidoController);
		assertNotNull(pessoaController);
		assertNotNull(produtoController);

		assertNotNull(pedidoService);
		assertNotNull(pessoaService);
		assertNotNull(produtoService);
	}

}
