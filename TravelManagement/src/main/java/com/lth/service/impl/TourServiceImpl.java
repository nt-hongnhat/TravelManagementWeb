/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.service.impl;

import com.lth.pojos.Tour;
import com.lth.repository.TourRepository;
import com.lth.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 *
 * @author PC
 */
@Service
public class TourServiceImpl implements TourService{
    @Autowired
    private TourRepository tourRepository;

    @Override
    public List<Tour> getTours(Map<String, String> params, int page) {
        return null;
    }

    @Override
    public long countTour() {
        return this.tourRepository.countTour();
    }

    @Override
    public boolean addTour(Tour tour) {
        return this.tourRepository.addTour(tour);
    }

    @Override
    public boolean updateTour(Tour tour) {
        return this.tourRepository.updateTour(tour);
    }

    @Override
    public boolean deleteTour(Tour tour) {
        return this.tourRepository.deleteTour(tour);
    }

    @Override
    public Tour findTourById(long tourId) {
        return this.tourRepository.findTourById(tourId);
    }


}
