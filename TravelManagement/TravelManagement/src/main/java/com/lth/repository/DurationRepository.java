package com.lth.repository;

import com.lth.pojos.Duration;

import java.util.List;

public interface DurationRepository {
    List<Duration> getDurations(int quantityDays);
    Duration getDurationByID(int id);
    boolean addDuration(Duration duration);
    boolean updateDuration(Duration duration);
    boolean deleteDuration(Duration duration);
}
