package com.lth.service.impl;

import com.lth.pojos.Trip;
import com.lth.repository.TripRepository;
import com.lth.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    TripRepository tripRepository;

    @Override
    public List<Trip> getTrips() {
        return tripRepository.getTrips();
    }

    @Override
    public boolean addTrip(Trip trip) {
        return tripRepository.addTrip(trip);
    }

    @Override
    public boolean checkTripIsNotExist(Trip trip) {
        return tripRepository.checkTripIsNotExist(trip);
    }

    @Override
    public Trip findTrip(Trip trip) {
        return tripRepository.findTrip(trip);
    }
}
