/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.controllers;

import com.lth.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
public class HomeController {
    @Autowired
    private TourService tourService;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("tours", this.tourService.getTours(""));
        return "index";
    }
}
