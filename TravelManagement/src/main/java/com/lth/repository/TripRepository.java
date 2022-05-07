package com.lth.repository;

import com.lth.pojos.Trip;

import java.util.List;

public interface TripRepository {
    List<Trip> getTrips();
    boolean addTrip(Trip trip);
    boolean checkTripIsNotExist(Trip trip);
    Trip findTrip(Trip trip);
}
