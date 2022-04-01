package com.lth.pojos;

import javax.persistence.*;

@Entity
@Table(name = "tour_detail", indexes = {
        @Index(name = "fk_tour_detail_place_idx", columnList = "place_id")
})
public class TourDetail {
    @EmbeddedId
    private TourDetailId id;

    private Tour tour;

    private Place place;

    @MapsId("placeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "place_id", nullable = false)
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @MapsId("tourId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tour_id", nullable = false)
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public TourDetailId getId() {
        return id;
    }

    public void setId(TourDetailId id) {
        this.id = id;
    }
}