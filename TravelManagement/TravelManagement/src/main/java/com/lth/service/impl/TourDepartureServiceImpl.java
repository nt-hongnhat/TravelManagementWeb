package com.lth.service.impl;

import com.lth.pojos.TourDeparture;
import com.lth.repository.TourDepartureRepository;
import com.lth.service.TourDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TourDepartureServiceImpl implements TourDepartureService {
    @Autowired
    TourDepartureRepository tourDepartureRepository;

    @Override
    public List<TourDeparture> findTourDepartureByTourId(long tourId) {
        return tourDepartureRepository.findTourDepartureByTourId(tourId);
    }

    @Override
    public List<Integer> getYear() {
        return tourDepartureRepository.getYear();
    }
}
