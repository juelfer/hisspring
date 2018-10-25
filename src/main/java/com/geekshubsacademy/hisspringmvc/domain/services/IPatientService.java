package com.geekshubsacademy.hisspringmvc.domain.services;

import com.geekshubsacademy.hisspringmvc.domain.entities.Patients;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
    public List<Patients> listPatients();
    public void addPatient(Patients patient);
    public Optional<Patients> showPatient(Long id);
}
