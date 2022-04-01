package com.lth.pojos;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer bookingId;

    private BigDecimal price;

    private Type type;

    private Integer surchargeId;

    @Column(name = "surcharge_id")
    public Integer getSurchargeId() {
        return surchargeId;
    }

    public void setSurchargeId(Integer surchargeId) {
        this.surchargeId = surchargeId;
    }

    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Column(name = "price", nullable = false, precision = 12)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "booking_id", nullable = false)
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}