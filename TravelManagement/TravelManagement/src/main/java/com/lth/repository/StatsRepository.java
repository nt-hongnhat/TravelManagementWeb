package com.lth.repository;

import java.util.List;

public interface StatsRepository {
    List<Object[]> numberOfToursStatsByMonth(int year);
    List<Object[]> numberOfToursStatsByYear();
    List<Object[]> revenueByMonth(int year);
    List<Object[]> revenueByYear();
}
