package com.lth.controllers.user;

import com.lth.pojos.*;
import com.lth.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@PropertySource("classpath:pagination.properties")
@RequestMapping("")
public class TourController {
    @Autowired
    TourService tourService;
    @Autowired
    TourPlaceService tourPlaceService;
    @Autowired
    TourScheduleService tourScheduleService;
    @Autowired
    TourDepartureService tourDepartureService;
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    SurchangeService surchangeService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("provinces", this.provinceService.getProvinces(""));
    }

    @GetMapping("/tour/{id}")
    public String tourDetail(ModelMap modelMap, @PathVariable("id") int id) {
        Tour tour = tourService.findTourById(id);
        List<TourPlace> tourPlace = tourPlaceService.findTourPlaceByTourId(id);
        Object[] rating = feedbackService.getRatingByTourId(id);
        List<TourSchedule> tourSchedules = tourScheduleService.findTourScheduleByTourId(id);
        List<TourDeparture> tourDepartures = tourDepartureService.findTourDepartureByTourId(id);
        List<Date> departureDate = tourDepartureService.findDateByTourId(id);
        modelMap.put("tour", tour);
        modelMap.put("tourPlace", tourPlace);
        modelMap.put("tourSchedules", tourSchedules);
        modelMap.put("tourDepartures", tourDepartures);
        modelMap.put("booking", new Booking());

        Date minDate = tourDepartures.stream().map(u -> u.getDeparture()).min(Date::compareTo).get();
        modelMap.put("minDate", minDate);
        if (rating == null) {
            rating[0] = 0;
            rating[1] = 5;
            modelMap.put("rating", rating);
        } else
            modelMap.put("rating", rating);

        return "user.index.tourdetail";
    }

    @GetMapping("/tour/{id}/abate")
    public String abateTour(ModelMap modelMap, @PathVariable("id") int id) {
        Tour tour = tourService.findTourById(id);
        List<TourDeparture> tourDepartures = tourDepartureService.findTourDepartureByTourId(id);
        List<Surcharge> surcharges = surchangeService.getSurchange();
        Date minDate = tourDepartures.stream().map(u -> u.getDeparture()).min(Date::compareTo).get();

        modelMap.put("minDate", minDate);
        modelMap.put("tour", tour);
        modelMap.put("surchanges", surcharges);
        modelMap.put("booking", new Booking());

        return "user.index.abate";
    }


    @GetMapping("/tours/{categoryId}")
    public String toursSearch(Model model, @PathVariable("categoryId") int categoryId, @RequestParam(required = false) Map<String, String> params) {
//
//        String departureDate = params.get("departureDate");
//        String departureProvince = params.getOrDefault("departureProvince", "");
//        String destinationProvince = params.getOrDefault("destinationProvince", "");
        Category category = this.categoryService.getCategoryByID(categoryId);
        params.put("categoryId", String.valueOf(categoryId));
        model.addAttribute("toursByCategoryId", category.getTours());
        model.addAttribute("toursByKeyword", this.tourService.getTours(params,1));

        model.addAttribute("categoryName", category.getName());

        return "user.index.tour";
    }
}
