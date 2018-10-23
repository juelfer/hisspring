package com.geekshubsacademy.hisspringmvc.domain.dao;

import com.geekshubsacademy.hisspringmvc.domain.entities.Patients;
import org.springframework.data.repository.CrudRepository;

public interface IPatientDao extends CrudRepository<Patients, Long> {
}
