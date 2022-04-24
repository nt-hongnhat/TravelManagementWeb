package com.lth.pojos;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity(name = "TourPlace")
@XmlRootElement
@Table(name = "tour_places", indexes = {
        @Index(name = "fk_tour_places_idx1", columnList = "places_id"),
        @Index(name = "fk_tour_places_idx", columnList = "tour_id")
})
public class TourPlace implements Serializable {
    private static final long serialVersionUID = 5713359751253164699L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "places_id")
    private Place places;

    public Integer getId() {
        return id;
    }

    public TourPlace setId(Integer id) {
        this.id = id;
        return this;
    }

    public Tour getTour() {
        return tour;
    }

    public TourPlace setTour(Tour tour) {
        this.tour = tour;
        return this;
    }

    public Place getPlaces() {
        return places;
    }

    public TourPlace setPlaces(Place places) {
        this.places = places;
        return this;
    }

}