/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.repository;

import com.lth.pojos.Tour;
import org.hibernate.Session;

import java.util.List;

/**
 *
 * @author PC
 */


public interface TourRepository {
    List<Tour> getTours(String keyword, int page);
    long countTour();
    boolean addTour(Tour tour);
    boolean updateTour(Tour tour);
    boolean deleteTour(Tour tour);
    Tour getTourByID(int tourID);
    List<Tour> getToursByCategory(int categoryID, int page);
}
