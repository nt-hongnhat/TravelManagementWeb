package com.lth.repository;

import com.lth.pojos.Province;

import java.util.List;

public interface LocationProvinceRepository {
    List<Province> getProvince();
    Province findProvinceById(long provinceId);
}
