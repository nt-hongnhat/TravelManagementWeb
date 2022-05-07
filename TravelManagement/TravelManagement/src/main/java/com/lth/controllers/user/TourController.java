package com.lth.controllers.user;

import com.lth.pojos.*;
import com.lth.service.*;
import com.lth.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
@PropertySource({"classpath:pagination.properties", "classpath:mail.properties"})
@RequestMapping("")
public class TourController {
    @Autowired
    private Environment env;
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
    BookingService bookingService;
    @Autowired
    UserService userService;

    Properties properties = new Properties();

    @InitBinder("booking")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "departureDate",
                new CustomDateEditor(dateFormatter, true));
    }


    @GetMapping ("/tour/{id}")
    public String tourDetail(ModelMap modelMap, @PathVariable("id") int id) {
        Tour tour = tourService.findTourById(id);
        List<TourPlace> tourPlace = tourPlaceService.findTourPlaceByTourId(id);
        Object[] rating = feedbackService.getRatingByTourId(id);
        List<TourSchedule> tourSchedules = tourScheduleService.findTourScheduleByTourId(id);
        List<TourDeparture> tourDepartures = tourDepartureService.findTourDepartureByTourId(id);

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

    @GetMapping("/tour/abate/announce/{id}")
    public String annouce(ModelMap modelMap, @PathVariable("id") int id) {
        modelMap.put("message", "Đặt tour thành công");
        modelMap.put("bookingId", id);
        return "user.index.success";
    }

    @PostMapping("/booking/save")
    public String addBooking(ModelMap modelMap, @Valid @ModelAttribute("booking") Booking booking,
                           BindingResult bindingResult, @RequestParam("abateType") String abateType,
                           Authentication authentication) throws MessagingException {

        List<Surcharge> surcharges = surchangeService.getSurchange();
        Tour tour = tourService.findTourById(booking.getTour().getId());
        User user = null;

        if (authentication != null) {
            String username = authentication.getName();
            user = (User) userService.getUser(username).get(0);
        }

        if (bindingResult.hasErrors()) {
            modelMap.put("tour", tour);
            modelMap.put("message", "Đặt tour thất bại");
            return "user.index.abate";
        }

        long price = tour.getPrice();
        long adultPrice = (long) Math.round(price / 1000) * 1000
                * booking.getBookingDetail().getNumberAdult();
        long ageGroup511Price = (long) Math.round(price * surcharges.get(1).getPercentage() / 1000) * 1000
                * booking.getBookingDetail().getNumberAgegroup511();
        long ageGroup25Price = (long) Math.round(price * surcharges.get(2).getPercentage() / 1000) * 1000
                * booking.getBookingDetail().getNumberAgegroup25();
        long ageGroup02Price = (long) Math.round(price * surcharges.get(3).getPercentage() / 1000) * 1000
                * booking.getBookingDetail().getNumberAgegroup02();

        String message = "";

        switch (abateType) {
            case "radioDefault":
                booking.setTour(tour);
                booking.setUser(user);
                booking.getBookingDetail().setIsPayment(false);
                booking.getBookingDetail().setTotalPrice(adultPrice + ageGroup511Price + ageGroup25Price * ageGroup02Price);
                if (booking.getId() == 0) {
                    if (bookingService.addBooking(booking) == true) {
//                        MailUtils mailUtils = new MailUtils(env, properties);
//                        mailUtils.sendMail("1951052054hieu@ou.edu.vn",
//                                "TravelMore - Tour", "Đặt tour thành công");
//
                    }
                }
                else
                    System.err.println("Đặt tour thất bại");
                break;
            case "radioMomo":
                break;
            case "radioBanking":
                break;
            case "radioVnpay":
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + abateType);
        }

        return "redirect:/tour/abate/announce/" + booking.getId();
    }
}
