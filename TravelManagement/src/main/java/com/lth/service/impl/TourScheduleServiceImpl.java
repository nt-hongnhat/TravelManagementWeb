package com.lth.service.impl;

import com.lth.pojos.TourPlace;
import com.lth.repository.TourScheduleRepository;
import com.lth.service.TourScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourScheduleServiceImpl implements TourScheduleService {
    @Autowired
    TourScheduleRepository tourScheduleRepository;

    @Override
    public List<TourSchedule> findTourScheduleByTourId(long tourId) {
        return tourScheduleRepository.findTourScheduleByTourId(tourId);
    }
}
