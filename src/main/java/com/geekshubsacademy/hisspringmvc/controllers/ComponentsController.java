package com.geekshubsacademy.hisspringmvc.controllers;

import com.geekshubsacademy.hisspringmvc.models.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class ComponentsController {

//    @GetMapping("/")
//    public ModelAndView login()
//    {
//        ModelAndView mav = new ModelAndView("login");
//        mav.addObject("user", new UserLogin("user", "pass"));
//        return new ModelAndView("login");
//    }

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
}