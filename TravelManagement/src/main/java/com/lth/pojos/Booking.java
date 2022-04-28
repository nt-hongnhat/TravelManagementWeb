package com.lth.pojos;

import javax.persistence.*;
<<<<<<< HEAD
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Booking")
@XmlRootElement
@Table(name = "booking", indexes = {
        @Index(name = "fk_booking_tour_idx", columnList = "tour_id"),
        @Index(name = "fk_booking_user_idx", columnList = "user_id")
})
public class Booking implements Serializable {
    private static final long serialVersionUID = -5501102043128342986L;
=======
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {
>>>>>>> 7198885909cc7c98b99a5a0c1227b2cfcf76bb02
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
    private Integer departureLocation;

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

    public Integer getDepartureLocation() {
        return departureLocation;
    }

<<<<<<< HEAD
    public Booking setDepartureLocation(Integer departureLocationId) {
        this.departureLocation = departureLocationId;
        return this;
=======
    public void setDepartureLocationId(Integer departureLocationId) {
        this.departureLocationId = departureLocationId;
>>>>>>> 7198885909cc7c98b99a5a0c1227b2cfcf76bb02
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