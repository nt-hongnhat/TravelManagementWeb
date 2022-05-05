package com.lth.service;

import com.lth.pojos.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> getProvinces(String name);
    Province findProvinceById(int id);
    boolean updateProvince(Province province);
}
