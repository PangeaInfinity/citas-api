package com.pangea.cita_api.service;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T t);
    T update(T t);
    void deleteById(ID id);
}
