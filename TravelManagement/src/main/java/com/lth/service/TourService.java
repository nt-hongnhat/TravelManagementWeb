/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.service;

import com.lth.pojos.Tour;
import java.util.List;

/**
 *
 * @author PC
 */
public interface TourService {
    List<Tour> getTours(String keyword, int page);
    long countTour();
    boolean addTour(Tour tour);
    boolean updateTour(Tour tour);
    boolean deleteTour(Tour tour);
    Tour getTourByID(int tourID);
    List<Tour> getToursByCategory(int categoryID, int page);
}
