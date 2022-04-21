/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.service.impl;

import com.lth.pojos.Tour;
import com.lth.repository.TourRepository;
import com.lth.service.TourService;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author PC
 */
@Service
public class TourServiceImpl implements TourService{
    @Autowired
    private TourRepository tourRepository;
    
    @Override
    public List<Tour> getTours(String keyword,int page) {
        return this.tourRepository.getTours(keyword, page);
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
    public List<Tour> getToursByCategory(int categoryID) {
        return this.tourRepository.getToursByCategory(categoryID);
    }

}
