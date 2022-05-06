package com.lth.service.impl;

import com.lth.pojos.Province;
import com.lth.repository.LocationProvinceRepository;
import com.lth.service.LocationProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationProvinceServiceImpl implements LocationProvinceService {
    @Autowired
    LocationProvinceRepository locationProvinceRepository;

    @Override
    public List<Province> getProvince() {
        return locationProvinceRepository.getProvince();
    }
}
