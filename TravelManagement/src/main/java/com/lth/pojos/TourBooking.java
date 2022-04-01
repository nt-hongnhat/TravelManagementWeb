package com.lth.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tour_booking")
public class TourBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer customerId;

    private Integer departureId;

    private LocalDateTime bookingDate;

    private Integer numberAdults;

    private Integer numberChildren;

    private BigDecimal total;

    @Column(name = "total", nullable = false, precision = 10)
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Column(name = "number_children", nullable = false)
    public Integer getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(Integer numberChildren) {
        this.numberChildren = numberChildren;
    }

    @Column(name = "number_adults", nullable = false)
    public Integer getNumberAdults() {
        return numberAdults;
    }

    public void setNumberAdults(Integer numberAdults) {
        this.numberAdults = numberAdults;
    }

    @Column(name = "booking_date", nullable = false)
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Column(name = "departure_id")
    public Integer getDepartureId() {
        return departureId;
    }

    public void setDepartureId(Integer departureId) {
        this.departureId = departureId;
    }

    @Column(name = "customer_id")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}