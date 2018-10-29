package com.geekshubsacademy.hisspringmvc.controllers;

import com.geekshubsacademy.hisspringmvc.domain.entities.Patients;
import com.geekshubsacademy.hisspringmvc.domain.services.IPatientService;
import com.geekshubsacademy.hisspringmvc.models.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class ComponentsController {


    @Autowired
    private IPatientService patientService;

    @GetMapping("/")
    public ModelAndView login()
    {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new UserLogin());
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
//        Date date = new Date();
//        dateFormat.format(date);
//        Patients patient = new Patients("Juan", "Fernández", "juelfer", "1234", "HC0001", date);
//        patientService.addPatient(patient);
        return mav;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard()
    {
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
    }


    @GetMapping("/addpatient")
    public ModelAndView addPatient()
    {
        ModelAndView addmav = new ModelAndView("addPatient");
        addmav.addObject("patient", new Patients());
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
//        Date date = new Date();
//        dateFormat.format(date);
//        Patients patient = new Patients("Juan", "Fernández", "juelfer", "1234", "HC0001", date);
//        patientService.addPatient(patient);
        return addmav;
    }


    @PostMapping("/newpatient")
    public ModelAndView newPatient(@ModelAttribute("patient") Patients patient)
    {
        ModelAndView newpatmav = new ModelAndView("newpatient");
        newpatmav.addObject("patient", patient);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
        Date date = new Date();
        dateFormat.format(date);
        patient.setCreatedAt(date);
        patientService.addPatient(patient);
        return newpatmav;
    }
}