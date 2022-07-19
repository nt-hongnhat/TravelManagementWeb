package com.lth.service.impl;

import com.lth.pojos.Booking;
import com.lth.repository.BookingRepository;
import com.lth.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public boolean addBooking(Booking booking) {
        booking.setCreatedDate(new Date());
        return bookingRepository.addBooking(booking);
    }

    @Override
    public List<Integer> getYear() {
        return bookingRepository.getYear();
    }
}
