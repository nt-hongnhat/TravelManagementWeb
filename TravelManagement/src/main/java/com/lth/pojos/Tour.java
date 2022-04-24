package com.lth.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false, precision = 12)
    private BigDecimal price;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "limit_customer", nullable = false)
    private Integer limitCustomer;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duration_id")
    private Duration duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @OneToMany(mappedBy = "tour")
    private Set<TourSchedule> tourSchedules = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tour")
    private Set<TourDeparture> tourDepartures = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tour")
    private Set<TourPlace> tourPlaces = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tour")
    private Set<Feedback> feedbacks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tour")
    private Set<Booking> bookings = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLimitCustomer() {
        return limitCustomer;
    }

    public void setLimitCustomer(Integer limitCustomer) {
        this.limitCustomer = limitCustomer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Set<TourSchedule> getTourSchedules() {
        return tourSchedules;
    }

    public void setTourSchedules(Set<TourSchedule> tourSchedules) {
        this.tourSchedules = tourSchedules;
    }

    public Set<TourDeparture> getTourDepartures() {
        return tourDepartures;
    }

    public void setTourDepartures(Set<TourDeparture> tourDepartures) {
        this.tourDepartures = tourDepartures;
    }

    public Set<TourPlace> getTourPlaces() {
        return tourPlaces;
    }

    public void setTourPlaces(Set<TourPlace> tourPlaces) {
        this.tourPlaces = tourPlaces;
    }

    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

}