package com.lth.service.impl;

import com.lth.pojos.Duration;
import com.lth.repository.DurationRepository;
import com.lth.service.DurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DurationServiceImpl implements DurationService {
    @Autowired
    private DurationRepository durationRepository;
    @Override
    public List<Duration> getDurations(int quantityDays) {
        return this.durationRepository.getDurations(quantityDays);
    }

    @Override
    public Duration getDurationByID(int id) {
        return this.durationRepository.getDurationByID(id);
    }

    @Override
    public boolean addDuration(Duration duration) {
        return this.durationRepository.addDuration(duration);
    }

    @Override
    public boolean updateDuration(Duration duration) {
        return this.durationRepository.updateDuration(duration);
    }

    @Override
    public boolean deleteDuration(Duration duration) {
        return this.durationRepository.deleteDuration(duration);
    }
}
