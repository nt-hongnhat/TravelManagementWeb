package com.lth.repository;

import com.lth.pojos.Feedback;

import java.util.List;

public interface FeedbackRepository {
    Object[] getRatingByTourId(int tourId);
    List<Feedback> getFeedbacks(int tourId);
    Feedback addFeedback(Feedback feedback);
}
