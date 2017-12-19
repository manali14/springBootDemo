package com.airtel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "login")
public class LoginController {

    @RequestMapping("/index")
    ModelAndView index() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/index");
        return modelAndView;
    }
}
