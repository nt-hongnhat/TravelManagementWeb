package com.lth.repository;

import com.lth.pojos.TourPlace;

import java.util.List;

public interface TourPlaceRepository {
    List<TourPlace> findTourPlaceByTourId(long tourId);
}
