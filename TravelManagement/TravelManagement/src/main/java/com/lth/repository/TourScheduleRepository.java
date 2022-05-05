package com.lth.repository;

import com.lth.pojos.TourPlace;
import com.lth.pojos.TourSchedule;

import java.util.List;

public interface TourScheduleRepository {
    List<TourSchedule> findTourScheduleByTourId(long tourId);
}
