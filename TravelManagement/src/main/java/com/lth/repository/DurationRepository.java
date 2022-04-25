package com.lth.repository;

import com.lth.pojos.Duration;

import java.util.List;
import java.util.Map;

public interface DurationRepository {
    List<Duration> getDurations(int quantityDays);
    Duration getDurationByID(int id);
    boolean addDuration(Duration duration);
    boolean updateDuration(Duration duration);
}
