package com.lth.service;

import com.lth.pojos.News;

import java.util.List;

public interface NewsService {
    List<News> getNews(String keyword, int page);
    long countNews();
    boolean addNews(News news);
    boolean updateNews(News news);
    boolean deleteNews(News news);
    News findNewsById(long newsId);
}
