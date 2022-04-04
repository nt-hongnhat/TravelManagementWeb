/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.controllers;

import com.lth.service.TourService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@PropertySource("classpath:pagination.properties")
public class HomeController {
    @Autowired
    private Environment env;
    @Autowired
    private TourService tourService;
    
    @RequestMapping("/")
    public String index(Model model,
            @RequestParam(required=false) Map<String, String> params) {
        String keyword = params.getOrDefault("kw", "");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        model.addAttribute("tours", 
                this.tourService.getTours(keyword, page));
        model.addAttribute("numberOfTourPaginationItem",
                this.tourService.countTour() / Integer.parseInt(env.getProperty("pagination.numberOfTour")));
        return "index";
    }
}
