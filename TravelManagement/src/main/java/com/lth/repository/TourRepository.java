/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.repository;

import com.lth.pojos.Tour;
import java.util.List;

/**
 *
 * @author PC
 */


public interface TourRepository {
    List<Tour> getTours(String keyword, int page);
    long countTour();
}
