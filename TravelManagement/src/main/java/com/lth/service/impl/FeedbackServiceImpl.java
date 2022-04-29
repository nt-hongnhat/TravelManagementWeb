package com.lth.service.impl;

import com.lth.repository.FeedbackRepository;
import com.lth.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public Object[] getRatingByTourId(int tourId) {
        return feedbackRepository.getRatingByTourId(tourId);
    }
}
