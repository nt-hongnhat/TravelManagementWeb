package com.lth.service.impl;

import com.lth.pojos.TourPlace;
import com.lth.repository.TourPlaceRepository;
import com.lth.service.TourPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TourPlaceServiceImpl implements TourPlaceService {
    @Autowired
    TourPlaceRepository tourPlaceRepository;

    @Override
    public List<TourPlace> findTourPlaceByTourId(long tourId) {
        return tourPlaceRepository.findTourPlaceByTourId(tourId);
    }
}
