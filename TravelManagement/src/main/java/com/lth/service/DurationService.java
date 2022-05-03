package com.lth.service;

import com.lth.pojos.Duration;

import java.util.List;

public interface DurationService {
    List<Duration> getDurations(int quantityDays);
    Duration getDurationByID(int id);
    boolean addDuration(Duration duration);
    boolean updateDuration(Duration duration);
    boolean deleteDuration(Duration duration);
}
