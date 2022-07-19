package com.lth.service;

import java.util.List;

public interface StatsService {
    List<Object[]> numberOfToursStatsByMonth(int year);
    List<Object[]> numberOfToursStatsByYear();
    List<Object[]> revenueByMonth(int year);
    List<Object[]> revenueByYear();
}
