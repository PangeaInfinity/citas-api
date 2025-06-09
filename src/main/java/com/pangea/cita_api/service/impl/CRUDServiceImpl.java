package com.pangea.cita_api.service.impl;

import com.pangea.cita_api.repository.IGenericRepo;
import com.pangea.cita_api.service.ICRUDService;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class CRUDServiceImpl<T,ID> implements ICRUDService<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepo().findById(id);
    }

    @Transactional
    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Transactional
    @Override
    public T update(T t) {
        return getRepo().save(t);
    }

    @Transactional
    @Override
    public void deleteById(ID id) {
        getRepo().deleteById(id);
    }
}
