package com.lth.pojos;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "departure_date", nullable = false)
    private Instant departureDate;

    @Column(name = "departure_location_id")
    private Integer departureLocationId;

    @Column(name = "number_adult", nullable = false)
    private Integer numberAdult;

    @Column(name = "number_child", nullable = false)
    private Integer numberChild;

    @OneToMany(mappedBy = "booking")
    private Set<BookingDetail> bookingDetails = new LinkedHashSet<>();

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Instant departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getDepartureLocationId() {
        return departureLocationId;
    }

    public void setDepartureLocationId(Integer departureLocationId) {
        this.departureLocationId = departureLocationId;
    }

    public Integer getNumberAdult() {
        return numberAdult;
    }

    public void setNumberAdult(Integer numberAdult) {
        this.numberAdult = numberAdult;
    }

    public Integer getNumberChild() {
        return numberChild;
    }

    public void setNumberChild(Integer numberChild) {
        this.numberChild = numberChild;
    }

    public Set<BookingDetail> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(Set<BookingDetail> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

}