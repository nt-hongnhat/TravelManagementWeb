package com.lth.service;

import com.lth.pojos.TourPlace;
import com.lth.pojos.TourSchedule;

import java.util.List;

public interface TourScheduleService {
    List<TourSchedule> findTourScheduleByTourId(long tourId);

}
