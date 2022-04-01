package com.lth.pojos;

import javax.persistence.*;

@Entity
@Table(name = "catalog")
public class Catalog {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String url;

    private String caption;

    private Post posts;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "posts_id", nullable = false)
    public Post getPosts() {
        return posts;
    }

    public void setPosts(Post posts) {
        this.posts = posts;
    }

    @Column(name = "caption", length = 100)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Column(name = "url", nullable = false, length = 50)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}