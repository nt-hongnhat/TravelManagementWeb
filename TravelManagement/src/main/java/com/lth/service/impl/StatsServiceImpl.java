package com.lth.service.impl;

import com.lth.repository.StatsRepository;
import com.lth.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    StatsRepository statsRepository;

    @Override
    public List<Object[]> numberOfToursStatsByMonth(int year) {
        return statsRepository.numberOfToursStatsByMonth(year);
    }

    @Override
    public List<Object[]> numberOfToursStatsByYear() {
        return statsRepository.numberOfToursStatsByYear();
    }

    @Override
    public List<Object[]> revenueByMonth(int year) {
        return statsRepository.revenueByMonth(year);
    }

    @Override
    public List<Object[]> revenueByYear() {
        return statsRepository.revenueByYear();
    }
}
