package com.lth.pojos;

import javax.persistence.*;
<<<<<<< HEAD
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
=======

@Entity
@Table(name = "tour_places")
public class TourPlace {
>>>>>>> 7198885909cc7c98b99a5a0c1227b2cfcf76bb02
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "places_id")
    private Place places;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Place getPlaces() {
        return places;
    }

    public void setPlaces(Place places) {
        this.places = places;
    }

}