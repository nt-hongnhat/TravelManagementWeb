package com.lth.controllers;

import com.lth.service.ProvinceService;
import com.lth.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TourController {
    @Autowired
    private TourService tourService;
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/tour")
    public String tour(Model model, @RequestParam(required = false) Map<String, String> params) {
        String keyword = params.getOrDefault("kw", "");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        model.addAttribute("tours", this.tourService.getTours(keyword, page));
        model.addAttribute("provinces", this.provinceService.getProvinces());
        return "tour";
    }
}
