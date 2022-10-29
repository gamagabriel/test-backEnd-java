package com.uol.api.model;

public interface Persister<T> {

    void save(T obj) ;
}
