package com.lth.pojos;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity(name = "BookingDetail")
@XmlRootElement
@Table(name = "booking_detail", indexes = {
        @Index(name = "fk_booking_detail_idx", columnList = "booking_id")
})
public class BookingDetail implements Serializable {
    private static final long serialVersionUID = -2346968037097589304L;
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

    public BookingDetail setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BookingDetail setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public Integer getCustomerPhone() {
        return customerPhone;
    }

    public BookingDetail setCustomerPhone(Integer customerPhone) {
        this.customerPhone = customerPhone;
        return this;
    }

    public Boolean getIsPayment() {
        return isPayment;
    }

    public BookingDetail setIsPayment(Boolean isPayment) {
        this.isPayment = isPayment;
        return this;
    }

    public Booking getBooking() {
        return booking;
    }

    public BookingDetail setBooking(Booking booking) {
        this.booking = booking;
        return this;
    }

}