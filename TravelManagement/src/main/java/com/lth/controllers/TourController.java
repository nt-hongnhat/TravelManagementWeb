package com.lth.controllers;

import com.lth.service.CategoryService;
import com.lth.service.ProvinceService;
import com.lth.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TourController {
    @Autowired
    private TourService tourService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/tour")
    public String tour(Model model, @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        String keyword = params.getOrDefault("kw", null);
        String categoryID = params.get("categoryID");
        if (categoryID == null) {
            model.addAttribute("tours", this.tourService.getTours(keyword, page));
        } else {
            model.addAttribute("tours", this.tourService.getToursByCategory(Integer.parseInt(categoryID), page));
        }
        model.addAttribute("provinces", this.provinceService.getProvinces());
        return "tour";
    }

    @GetMapping(name = "/{category}")
    public String toursByCategory(Model model, @PathVariable(value = "category") String category) {
        model.addAttribute("toursByCategory", this.tourService.getToursByCategory(1, 1));
        return "tour";
    }
}
