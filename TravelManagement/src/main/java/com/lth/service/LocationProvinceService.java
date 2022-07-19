package com.lth.service;

import com.lth.pojos.Province;

import java.util.List;

public interface LocationProvinceService {
    List<Province> getProvince();
    Province findProvinceById(long provinceId);
}
