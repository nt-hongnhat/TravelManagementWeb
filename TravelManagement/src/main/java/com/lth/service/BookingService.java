package com.lth.service;

import com.lth.pojos.Booking;

import java.util.List;

public interface BookingService {
    boolean addBooking(Booking booking);
    List<Integer> getYear();
}
