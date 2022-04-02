package com.lth.pojos;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "reaction", indexes = {
        @Index(name = "fk_reaction_news_idx", columnList = "news_id"),
        @Index(name = "fk_reaction_user_idx", columnList = "user_id")
})
public class Reaction {
    @Id
    @Column(name = "id", nullable = false, length = 45)
    private String id;

    private User user;

    private News news;

    private Boolean isLike = false;

    private String comment;

    private LocalDateTime createdDate;

    private Instant updatedDate;

    @Column(name = "updated_date", nullable = false)
    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Column(name = "created_date", nullable = false)
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "is_like", nullable = false)
    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id")
    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}