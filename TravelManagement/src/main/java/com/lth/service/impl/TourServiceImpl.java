/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.service.impl;

import com.lth.pojos.Tour;
import com.lth.repository.TourRepository;
import com.lth.service.TourService;
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
    public List<Tour> getTours(String keyword) {
        return this.tourRepository.getTours(keyword);
    }
    
}
