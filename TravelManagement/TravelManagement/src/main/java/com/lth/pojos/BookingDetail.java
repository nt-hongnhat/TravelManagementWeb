package com.lth.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "booking_detail")
public class BookingDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "number_adult")
    private int numberAdult;

    @Basic(optional = false)
    @NotNull
    @Column(name = "number_agegroup_0_2")
    private int numberAgegroup02;

    @Basic(optional = false)
    @NotNull
    @Column(name = "number_agegroup_2_5")
    private int numberAgegroup25;

    @Basic(optional = false)
    @NotNull
    @Column(name = "number_agegroup_5_11")
    private int numberAgegroup511;

    @Column(name = "is_payment", nullable = false)
    private Boolean isPayment = false;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private long totalPrice;

    @OneToOne(mappedBy = "bookingDetail")
    private Booking booking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Boolean isPayment) {
        this.isPayment = isPayment;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumberAgegroup511() {
        return numberAgegroup511;
    }

    public void setNumberAgegroup511(int numberAgegroup511) {
        this.numberAgegroup511 = numberAgegroup511;
    }

    public int getNumberAgegroup25() {
        return numberAgegroup25;
    }

    public void setNumberAgegroup25(int numberAgegroup25) {
        this.numberAgegroup25 = numberAgegroup25;
    }

    public int getNumberAgegroup02() {
        return numberAgegroup02;
    }

    public void setNumberAgegroup02(int numberAgegroup02) {
        this.numberAgegroup02 = numberAgegroup02;
    }

    public int getNumberAdult() {
        return numberAdult;
    }

    public void setNumberAdult(int numberAdult) {
        this.numberAdult = numberAdult;
    }
}