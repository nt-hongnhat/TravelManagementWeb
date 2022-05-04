/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.controllers.user;

import com.lth.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author PC
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:pagination.properties")
@RequestMapping("")
public class HomeController {
    @Autowired
    private Environment env;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TourService tourService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private DurationService durationService;
    @Autowired
    private TourDepartureService tourDepartureService;

    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("provinces", this.provinceService.getProvinces(""));
        model.addAttribute("durations", this.durationService.getDurations(0));
        model.addAttribute("departures", this.tourDepartureService.findTourDepartureByTourId(-1));
    }

    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam(required = false) Map<String, String> params) {
        String keyword = params.getOrDefault("kw", "");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));

        model.addAttribute("tours",
                this.tourService.findAll(page));
        model.addAttribute("numberOfTourPaginationItem",
                this.tourService.countTour() / pageNumberOfTour);
        model.addAttribute("provinces", this.provinceService.getProvinces(""));
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("news", this.newsService.getNews("", page));
        return "index";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }

}
