package com.lth.pojos;

import javax.persistence.*;
<<<<<<< HEAD
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "TourDeparture")
@XmlRootElement
@Table(name = "tour_departure", indexes = {
        @Index(name = "fk_td_tour_idx", columnList = "tour_id")
})
public class TourDeparture implements Serializable {
    private static final long serialVersionUID = -4616509128737460454L;
=======
import java.time.Instant;

@Entity
@Table(name = "tour_departure")
public class TourDeparture {
>>>>>>> 7198885909cc7c98b99a5a0c1227b2cfcf76bb02
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "departure", nullable = false)
    private Instant departure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDeparture() {
        return departure;
    }

    public void setDeparture(Instant departure) {
        this.departure = departure;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

}