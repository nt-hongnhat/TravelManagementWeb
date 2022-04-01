package com.lth.pojos;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TourDetailId implements Serializable {
    private static final long serialVersionUID = 532693815309843562L;
    @Column(name = "tour_id", nullable = false)
    private Integer tourId;
    @Column(name = "place_id", nullable = false)
    private Integer placeId;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, placeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TourDetailId entity = (TourDetailId) o;
        return Objects.equals(this.tourId, entity.tourId) &&
                Objects.equals(this.placeId, entity.placeId);
    }
}