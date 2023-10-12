package com.jpacomparisions.store.application;

public class ProdutoNotFoundException extends RuntimeException{

    public ProdutoNotFoundException(String format) {
        super(format);
    }

}
