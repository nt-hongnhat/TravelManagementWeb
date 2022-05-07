package com.lth.repository;

import com.lth.pojos.Tour;

import java.util.List;
import java.util.Map;

/**
 * @author PC
 */

public interface TourRepository {
    List<Tour> getTours(Map<String, String> params, int page);

    long countTour();

    boolean addTour(Tour tour);

    boolean updateTour(Tour tour);

    boolean deleteTour(Tour tour);

    Tour findTourById(long tourId);

    List<Tour> findAll(int page);
}
