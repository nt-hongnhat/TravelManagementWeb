package com.lth.service;

import com.lth.pojos.Trip;

import java.util.List;

public interface TripService {
    List<Trip> getTrips();
    boolean addTrip(Trip trip);
    boolean checkTripIsNotExist(Trip trip);
    Trip findTrip(Trip trip);

}
