package com.lth.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Booking")
@Table(name = "booking", indexes = {
        @Index(name = "fk_booking_tour_idx", columnList = "tour_id"),
        @Index(name = "fk_booking_user_idx", columnList = "user_id")
})
public class Booking implements Serializable {
    private static final long serialVersionUID = -5501102043128342986L;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

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

    public Booking setId(Integer id) {
        this.id = id;
        return this;
    }

    public Tour getTour() {
        return tour;
    }

    public Booking setTour(Tour tour) {
        this.tour = tour;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Booking setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Booking setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Booking setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public Integer getDepartureLocationId() {
        return departureLocationId;
    }

    public Booking setDepartureLocationId(Integer departureLocationId) {
        this.departureLocationId = departureLocationId;
        return this;
    }

    public Integer getNumberAdult() {
        return numberAdult;
    }

    public Booking setNumberAdult(Integer numberAdult) {
        this.numberAdult = numberAdult;
        return this;
    }

    public Integer getNumberChild() {
        return numberChild;
    }

    public Booking setNumberChild(Integer numberChild) {
        this.numberChild = numberChild;
        return this;
    }

    public Set<BookingDetail> getBookingDetails() {
        return bookingDetails;
    }

    public Booking setBookingDetails(Set<BookingDetail> bookingDetails) {
        this.bookingDetails = bookingDetails;
        return this;
    }

}