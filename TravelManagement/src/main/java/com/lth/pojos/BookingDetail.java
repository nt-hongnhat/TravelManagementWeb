package com.lth.pojos;

import javax.persistence.*;
<<<<<<< HEAD
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity(name = "BookingDetail")
@XmlRootElement
@Table(name = "booking_detail", indexes = {
        @Index(name = "fk_booking_detail_idx", columnList = "booking_id")
})
public class BookingDetail implements Serializable {
    private static final long serialVersionUID = -2346968037097589304L;
=======

@Entity
@Table(name = "booking_detail")
public class BookingDetail {
>>>>>>> 7198885909cc7c98b99a5a0c1227b2cfcf76bb02
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "customer_name", nullable = false, length = 45)
    private String customerName;

    @Column(name = "customer_phone", nullable = false)
    private Integer customerPhone;

    @Column(name = "is_payment", nullable = false)
    private Boolean isPayment = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Integer customerPhone) {
        this.customerPhone = customerPhone;
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

}