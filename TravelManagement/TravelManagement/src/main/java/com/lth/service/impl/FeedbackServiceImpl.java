package com.lth.service.impl;

import com.lth.pojos.Feedback;
import com.lth.pojos.Tour;
import com.lth.pojos.User;
import com.lth.repository.FeedbackRepository;
import com.lth.service.FeedbackService;
import com.lth.service.TourService;
import com.lth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    TourService tourService;
    @Autowired
    UserService userService;

    @Override
    public Object[] getRatingByTourId(int tourId) {
        return feedbackRepository.getRatingByTourId(tourId);
    }

    @Override
    public List<Feedback> getFeedbacks(int tourId) {
        return this.feedbackRepository.getFeedbacks(tourId);
    }

    @Override
    public Feedback addFeedback(int rating, String comment, int tourId, int userId) {
        Tour tour = this.tourService.findTourById(tourId);
        User user = this.userService.findUserById(userId);
        Feedback feedback = new Feedback();
        feedback.setTour(tour);
        feedback.setUser(user);
        feedback.setCreatedDate(Calendar.getInstance().getTime());
        feedback.setUpdatedDate(Calendar.getInstance().getTime());
        feedback.setRating((short) rating);
        feedback.setComment(comment);
        return this.feedbackRepository.addFeedback(feedback);
    }

}
