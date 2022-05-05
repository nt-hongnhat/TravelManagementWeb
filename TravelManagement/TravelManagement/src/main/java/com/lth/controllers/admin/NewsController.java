package com.lth.controllers.admin;

import com.lth.pojos.News;
import com.lth.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@PropertySource("classpath:pagination.properties")
@RequestMapping("admin")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private Environment env;


    @RequestMapping(value ="/news" ,method = RequestMethod.GET)
    public String getNewsP(ModelMap modelMap,
                          @RequestParam(required = false) Map<String, String> params) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        String keyword = params.getOrDefault("kw", "");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        modelMap.addAttribute("news",
                this.newsService.getNews(keyword, page));
        modelMap.put("numberOfTourPaginationItem",
                this.newsService.countNews() / pageNumberOfTour);
        return "admin.index.news";
    }

    @RequestMapping(value ="/news/form", method = RequestMethod.GET)
    public String formNewsP(ModelMap modelMap) {
        modelMap.put("pieceOfNews", new News(0));
        modelMap.put("valueButton", "Lưu");
        return "admin.index.news.form";
    }

    @RequestMapping(value = "/news/save", method =  RequestMethod.POST)
    public String saveNewsP(ModelMap modelMap, @ModelAttribute(value = "pieceOfNews") News news) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));

        if(news.getId() == 0) {
            newsService.addNews(news);
        } else {
            newsService.updateNews(news);
        }
        modelMap.put("news",
                this.newsService.getNews("", 1));
        modelMap.put("numberOfTourPaginationItem",
                this.newsService.countNews() / pageNumberOfTour);

        return "admin.index.news";
    }

    @RequestMapping (value ="/news/edit/{newsId}", method = RequestMethod.GET)
    public String editNews(ModelMap modelMap, @PathVariable("newsId") int newsId) {
        News news = newsService.findNewsById(newsId);
        modelMap.put("valueButton", "Sửa");
        modelMap.put("pieceOfNews", news);
        return "admin.index.news.form";
    }

    @RequestMapping (value ="/news/delete/{newsId}", method = RequestMethod.GET)
    public String deleteNews(ModelMap modelMap, @PathVariable("newsId") int newsId) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        News news = newsService.findNewsById(newsId);
        if (news != null) {
            newsService.deleteNews(news);
        }
        modelMap.put("news",
                this.newsService.getNews("", 1));
        modelMap.put("numberOfTourPaginationItem",
                this.newsService.countNews() / pageNumberOfTour);
        return "admin.index.news";
    }
}
