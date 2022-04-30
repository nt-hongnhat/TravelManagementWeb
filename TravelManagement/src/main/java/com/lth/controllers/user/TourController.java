package com.lth.controllers.user;

import com.lth.pojos.*;
import com.lth.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

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

    @GetMapping ("/tour/{id}")
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
        if(rating == null) {
            rating[0] = 0;
            rating[1] = 5;
            modelMap.put("rating", rating);
        }
        else
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
}
