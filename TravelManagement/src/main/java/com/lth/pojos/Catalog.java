package com.lth.pojos;

import javax.persistence.*;

@Entity
@Table(name = "catalog", indexes = {
        @Index(name = "fk_catalog_picture_idx", columnList = "picture_id"),
        @Index(name = "fk_catalog_news_idx", columnList = "news_id")
})
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Picture picture;

    private News news;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id")
    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id")
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}