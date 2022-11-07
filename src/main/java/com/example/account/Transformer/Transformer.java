package com.example.account.Transformer;

public interface Transformer<M,E> {

    E toEntity(M m);

    M toModel(E e);
}
