package com.lth.controllers.admin;

import com.lth.pojos.*;
import com.lth.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

    @Controller
    @PropertySource("classpath:pagination.properties")
    @RequestMapping("admin")
public class TourAdminController {
    @Autowired
    private TourService tourService;
        @Autowired
        private CategoryService categoryService;
        @Autowired
        private DurationService durationService;
        @Autowired
        private LocationProvinceService locationProvinceService;
    @Autowired
    private Environment env;


    @RequestMapping(value ="/tour" ,method = RequestMethod.GET)
    public String getTour(ModelMap modelMap,
                          @RequestParam(required = false) Map<String, String> params) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        String keyword = params.getOrDefault("kw", "");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        modelMap.addAttribute("tours",
                this.tourService.getTours(params, page));
        modelMap.put("numberOfTourPaginationItem",
                this.tourService.countTour() / pageNumberOfTour);
        return "admin.index.tour";
    }

    @RequestMapping(value ="/tour/form", method = RequestMethod.GET)
    public String formTour(ModelMap modelMap) {
        List<Category> categories = categoryService.getCategories();
        List<Duration> durations = durationService.getDurations(0);
        List<Province> provinces = locationProvinceService.getProvince();
        modelMap.put("tour", new Tour());
        modelMap.put("categories", categories);
        modelMap.put("durations", durations);
        modelMap.put("provinces", provinces);
        modelMap.put("valueButton", "Lưu");
        return "admin.index.tour.form";
    }

    @PostMapping ("/tour/save")
    public String saveTour(ModelMap modelMap, @ModelAttribute(value = "tour") Tour tour) {

        if(tour.getId() == 0) {
            tourService.addTour(tour);
        } else {
            tourService.updateTour(tour);
        }

        return "redirect:/admin/tour";
    }

    @RequestMapping (value ="/tour/edit/{tourId}", method = RequestMethod.GET)
    public String editTour(ModelMap modelMap, @PathVariable("tourId") int tourId) {
        Tour tour = tourService.findTourById(tourId);
        modelMap.put("valueButton", "Sửa");
        modelMap.put("tour", tour);
        return "admin.index.tour.form";
    }

    @RequestMapping (value ="/tour/delete/{tourId}", method = RequestMethod.GET)
    public String deleteTour(ModelMap modelMap, @PathVariable("tourId") int tourId) {
        Tour tour = tourService.findTourById(tourId);

        if (tour != null) {
            tourService.deleteTour(tour);
        }

        return "redirect:/admin/tour";
    }
}
