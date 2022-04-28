package com.lth.repository;

import com.lth.pojos.TourPlace;

import java.util.List;

public interface TourScheduleRepository {
    List<TourPlace> findTourScheduleByTourId(long tourId);
}
