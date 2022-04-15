package com.lth.service.impl;

import com.lth.pojos.Province;
import com.lth.repository.ProvinceRepository;
import com.lth.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> getProvinces() {
        return this.provinceRepository.getProvinces();
    }
}
