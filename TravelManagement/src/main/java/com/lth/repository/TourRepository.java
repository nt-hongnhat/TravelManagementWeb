/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.repository;

import com.lth.pojos.Tour;
import com.lth.pojos.Trip;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */


public interface TourRepository {
    List<Tour> getTours(Map<String, String> params, int page);
    long countTour();
    boolean addTour(Tour tour);
    boolean updateTour(Tour tour);
    boolean deleteTour(Tour tour);
    Tour findTourById(long tourId);
}
