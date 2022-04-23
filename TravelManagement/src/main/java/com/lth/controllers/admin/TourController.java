package com.lth.controllers.admin;

import com.lth.pojos.Tour;
import com.lth.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("admin")
public class TourController {
    @Autowired
    private TourService tourService;

    @RequestMapping(value ="/tour" ,method = RequestMethod.GET)
    public String getTour(Model model,
                          @RequestParam(required = false) Map<String, String> params) {
        String keyword = params.getOrDefault("kw", "");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        model.addAttribute("tours",
                this.tourService.getTours(keyword, page));
        model.addAttribute("numberOfTour",
                this.tourService.countTour());
        return "admin.index.tour";
    }

    @RequestMapping(value ="/tour/new" ,method = RequestMethod.GET)
    public String formTour(Model model) {
        model.addAttribute("tour", new Tour());
        return "admin.index.tour.form";
    }

    @RequestMapping(path ="/tour/new" ,method = RequestMethod.POST)
    public String addTour(Model model,
                          @ModelAttribute(value = "tour") Tour tour) {
        if(this.tourService.addTour(tour))
            model.addAttribute("message", "Thêm tour thành công!!");
        else
            model.addAttribute("message", "Thêm tour thất bại!!");
        return "admin.index.tour.form";
    }

}
