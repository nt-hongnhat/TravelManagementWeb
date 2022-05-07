package com.lth.controllers.admin;

import com.lth.pojos.TourDeparture;
import com.lth.service.BookingService;
import com.lth.service.StatsService;
import com.lth.service.TourDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class ChartController {
    @Autowired
    StatsService statsService;
    @Autowired
    TourDepartureService tourDepartureService;
    @Autowired
    BookingService bookingService;

    @GetMapping("chartNumberOfTour")
    public String statsNumberOfTour(ModelMap modelMap, @RequestParam(value = "year") int year){
        if (year == 0)
            year = Calendar.getInstance().get(Calendar.YEAR);


        List<Integer> yearCb = tourDepartureService.getYear();
        List<Object[]> toursStatsByMonth = statsService.numberOfToursStatsByMonth(year);
        List<Object[]> toursStatsByYear = statsService.numberOfToursStatsByYear();
        modelMap.put("toursStatsByMonth", toursStatsByMonth);
        modelMap.put("toursStatsByYear", toursStatsByYear);
        modelMap.put("yearCb", yearCb);
        modelMap.put("year", year);

        return "admin.chart.numberOfTour";
    }

    @GetMapping("chartRevenue")
    public String statsRevenue(ModelMap modelMap, @RequestParam(value = "year") int year){
        if (year == 0)
            year = Calendar.getInstance().get(Calendar.YEAR);


        List<Integer> yearCb = bookingService.getYear();
        List<Object[]> revenueStatsByMonth = statsService.revenueByMonth(year);
        List<Object[]> revenueStatsByYear = statsService.revenueByYear();
        modelMap.put("revenueStatsByMonth", revenueStatsByMonth);
        modelMap.put("revenueStatsByYear", revenueStatsByYear);
        modelMap.put("yearCb", yearCb);
        modelMap.put("year", year);

        return "admin.chart.revenue";
    }

}
