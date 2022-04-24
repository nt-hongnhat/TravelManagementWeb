package com.lth.pojos;

import javax.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure", nullable = false)
    private Date departure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    public Integer getId() {
        return id;
    }

    public TourDeparture setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getDeparture() {
        return departure;
    }

    public TourDeparture setDeparture(Date departure) {
        this.departure = departure;
        return this;
    }

    public Tour getTour() {
        return tour;
    }

    public TourDeparture setTour(Tour tour) {
        this.tour = tour;
        return this;
    }

}