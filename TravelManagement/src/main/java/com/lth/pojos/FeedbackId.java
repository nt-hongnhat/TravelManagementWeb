package com.lth.pojos;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FeedbackId implements Serializable {
    private static final long serialVersionUID = -7163088711579645827L;
    @Column(name = "tour_id", nullable = false)
    private Integer tourId;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FeedbackId entity = (FeedbackId) o;
        return Objects.equals(this.tourId, entity.tourId) &&
                Objects.equals(this.userId, entity.userId);
    }
}