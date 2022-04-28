package com.lth.service;

import com.lth.pojos.TourPlace;

import java.util.List;

public interface TourPlaceService {
    List<TourPlace> findTourPlaceByTourId(long tourId);
}
