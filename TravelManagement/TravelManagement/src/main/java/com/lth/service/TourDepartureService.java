package com.lth.service;

import com.lth.pojos.TourDeparture;
import com.lth.repository.TourDepartureRepository;

import java.util.Date;
import java.util.List;

public interface TourDepartureService {
    List<TourDeparture> findTourDepartureByTourId (long tourId);
}
