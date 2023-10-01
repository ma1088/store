package com.jpacomparisions.store.adapters.primary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpacomparisions.store.adapters.primary.dto.DefaultResponse;
import com.jpacomparisions.store.adapters.primary.dto.PessoaDto;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @PostMapping("/fisica")
    public ResponseEntity<DefaultResponse> novaPessoaFisica(@RequestBody PessoaDto pessoa){
        return null;
      // TODO document why this method is empty
    }

    @PostMapping("/juridica")
    public ResponseEntity<DefaultResponse> novaPessoaJuridica(@RequestBody PessoaDto pessoa){
        return null;
      // TODO document why this method is empty
    }

}
