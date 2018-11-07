package com.geekshubsacademy.hisspringmvc.components;


import com.geekshubsacademy.hisspringmvc.domain.entities.Patients;
import com.geekshubsacademy.hisspringmvc.domain.services.IPatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Qualifier("PatientsComponent")
public class PatientsComponent {

    private static final Log logger = LogFactory.getLog("PatientsComponent.class");

    @Autowired
    private IPatientService patientService;

    public Patients createPatient()
    {
        Patients patient = new Patients();
        patient.setHistory(UidGenerate());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        patient.setCreatedAt(date);
        return patient;
    }

    public void addPatient (Patients patient)
    {
        patientService.savePatient(patient);
    }

    public List<Patients> showPatients()
    {
        logger.info(patientService.listPatients());
        return patientService.listPatients();
    }

    public Optional<Patients> getPatientById (Long id)
    {
        return patientService.showPatient(id);
    }

    private String UidGenerate() {
        UID uid = new UID();
        return "hist"+uid;
    }
}
