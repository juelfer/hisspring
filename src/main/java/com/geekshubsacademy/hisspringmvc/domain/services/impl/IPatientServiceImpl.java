package com.geekshubsacademy.hisspringmvc.domain.services.impl;

import com.geekshubsacademy.hisspringmvc.domain.dao.IPatientDao;
import com.geekshubsacademy.hisspringmvc.domain.entities.Patients;
import com.geekshubsacademy.hisspringmvc.domain.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IPatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientDao patientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Patients> listPatients()
    {
        return (List<Patients>) patientDao.findAll();
    }

    @Override
    @Transactional
    public void addPatient(Patients patient)
    {
        patientDao.save(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Patients> showPatient(Long id)
    {
        return patientDao.findById(id);
    }

    @Transactional
    public void deletePatient(Patients patient)
    {
        patientDao.delete(patient);
    }
}
