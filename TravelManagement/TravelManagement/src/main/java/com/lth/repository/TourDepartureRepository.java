package com.lth.repository;

import com.lth.pojos.TourDeparture;

import java.util.Date;
import java.util.List;

public interface TourDepartureRepository {
    List<TourDeparture> findTourDepartureByTourId (long tourId);
    List<Integer> getYear();
}
