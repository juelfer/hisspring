package com.geekshubsacademy.hisspringmvc.domain.dao.impl;

import com.geekshubsacademy.hisspringmvc.domain.dao.IPatientDao;
import com.geekshubsacademy.hisspringmvc.domain.entities.Patients;

import java.util.Optional;

public class IPatientDaoImpl implements IPatientDao {

    @Override
    public <S extends Patients> S save(S s) {
        return null;
    }

    @Override
    public <S extends Patients> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Patients> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Patients> findAll() {
        return null;
    }

    @Override
    public Iterable<Patients> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Patients patients) {

    }

    @Override
    public void deleteAll(Iterable<? extends Patients> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
