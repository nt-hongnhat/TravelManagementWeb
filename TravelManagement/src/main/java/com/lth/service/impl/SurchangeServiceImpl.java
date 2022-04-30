package com.lth.service.impl;

import com.lth.pojos.Surcharge;
import com.lth.repository.SurchangeRepository;
import com.lth.service.SurchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurchangeServiceImpl implements SurchangeService {
    @Autowired
    SurchangeRepository surchangeRepository;

    @Override
    public List<Surcharge> getSurchange() {
        return surchangeRepository.getSurchange();
    }
}
