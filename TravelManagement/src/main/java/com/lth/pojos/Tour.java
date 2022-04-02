package com.lth.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tour", indexes = {
        @Index(name = "fk_tour_schedule_idx", columnList = "duration_id"),
        @Index(name = "fk_tour_trip_idx", columnList = "trip_id")
})
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private BigDecimal price;

    private String description;

    private Trip trip;

    private Duration duration;

    private Set<TourDetail> tourDetails = new LinkedHashSet<>();

    private Set<Transport> transports = new LinkedHashSet<>();

    private Set<TourBooking> tourBookings = new LinkedHashSet<>();

    private Set<Feedback> feedbacks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tour")
    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @OneToMany(mappedBy = "tour")
    public Set<TourBooking> getTourBookings() {
        return tourBookings;
    }

    public void setTourBookings(Set<TourBooking> tourBookings) {
        this.tourBookings = tourBookings;
    }

    @OneToMany(mappedBy = "tour")
    public Set<Transport> getTransports() {
        return transports;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

    @OneToMany(mappedBy = "tour")
    public Set<TourDetail> getTourDetails() {
        return tourDetails;
    }

    public void setTourDetails(Set<TourDetail> tourDetails) {
        this.tourDetails = tourDetails;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duration_id")
    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price", nullable = false, precision = 12)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}