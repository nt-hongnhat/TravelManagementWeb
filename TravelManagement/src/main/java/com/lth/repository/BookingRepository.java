package com.lth.repository;

import com.lth.pojos.Booking;

import java.util.List;

public interface BookingRepository {
    boolean addBooking(Booking booking);

    List<Integer> getYear();
}
