package com.geekshubsacademy.hisspringmvc.controllers;

import com.geekshubsacademy.hisspringmvc.components.PatientsComponent;
import com.geekshubsacademy.hisspringmvc.domain.entities.Patients;
import com.geekshubsacademy.hisspringmvc.domain.services.IPatientService;
import com.geekshubsacademy.hisspringmvc.models.UserLogin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
//@RequestMapping("/")
@SessionAttributes("patient")
public class InitController {

    private static final Log logger = LogFactory.getLog("InitController.class");

    @Autowired
//    private IPatientService patientService;
    private PatientsComponent patientsComponent;

    @GetMapping("/")
    public ModelAndView login()
    {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new UserLogin());
        return mav;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard()
    {
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
    }


    @GetMapping("/addpatient")
//    public ModelAndView addPatient()
    public String addPatient (Map<String, Object> model)
    {
//        ModelAndView addmav = new ModelAndView("addPatient");
//        addmav.addObject("patient", new Patients());
//        return addmav;
        model.put("patient", patientsComponent.createPatient());
        model.put("titulo", "Añadir paciente");
        return "addpatient";
    }

    @PostMapping("/addpatient")
//    public ModelAndView savePatient(Patients patient){
//        ModelAndView mv = new ModelAndView("patientslist");
//        mv.addObject("patient",patient);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
//        Date date = new Date();
//        dateFormat.format(date);
//        patient.setCreatedAt(date);
//        patientService.addPatient(patient);
//        return mv;
    public String savePatient(@Valid @ModelAttribute ("patient") Patients patient, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){
        if(result.hasErrors()){
            logger.info("Errores en datos introducidos");
            model.addAttribute("titulo", "Añadir paciente");
            return "addpatient";
        }
        patientsComponent.addPatient(patient);
        return "redirect:/patientslist";
    }

    @GetMapping("/patientslist")
    public ModelAndView patientList(){
        ModelAndView mv = new ModelAndView("patientslist");
        mv.addObject("titulo", "Listado de pacientes");
        mv.addObject("patients", patientsComponent.showPatients());
        return mv;
    }
}