package com.lth.repository;

import com.lth.pojos.News;

import java.util.List;

public interface NewsRepository {
    List<News> getNews(String keyword, int page);
    long countNews();
    boolean addNews(News news);
    boolean updateNews(News news);
    boolean deleteNews(News news);
}
