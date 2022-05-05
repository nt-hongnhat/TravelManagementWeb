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
    public List<Province> getProvinces(String name) {
        return this.provinceRepository.getProvinces(name);
    }

    @Override
    public Province findProvinceById(int id) {
        return this.provinceRepository.findProvinceById(id);
    }

    @Override
    public boolean updateProvince(Province province) {
        return this.provinceRepository.updateProvince(province);
    }
}
