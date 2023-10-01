package com.jpacomparisions.store.adapters.primary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.DefaultResponse;
import com.jpacomparisions.store.adapters.primary.dto.ProdutoDto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @PostMapping
    public ResponseEntity<DefaultResponse> novoProduto(@RequestBody ProdutoDto produto){
        return null;
      // TODO document why this method is empty
    }
}
