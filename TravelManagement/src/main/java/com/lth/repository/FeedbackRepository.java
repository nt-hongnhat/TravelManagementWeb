package com.lth.repository;

public interface FeedbackRepository {
    Object[] getRatingByTourId(int tourId);
}
