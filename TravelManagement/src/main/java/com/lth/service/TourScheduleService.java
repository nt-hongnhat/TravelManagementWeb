package com.lth.service;

import com.lth.pojos.TourPlace;

import java.util.List;

public interface TourScheduleService {
    List<TourPlace> findTourScheduleByTourId(long tourId);

}
