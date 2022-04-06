/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "tour_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourTicket.findAll", query = "SELECT t FROM TourTicket t"),
    @NamedQuery(name = "TourTicket.findById", query = "SELECT t FROM TourTicket t WHERE t.id = :id"),
    @NamedQuery(name = "TourTicket.findByType", query = "SELECT t FROM TourTicket t WHERE t.type = :type"),
    @NamedQuery(name = "TourTicket.findByPrice", query = "SELECT t FROM TourTicket t WHERE t.price = :price"),
    @NamedQuery(name = "TourTicket.findByIsPayment", query = "SELECT t FROM TourTicket t WHERE t.isPayment = :isPayment"),
    @NamedQuery(name = "TourTicket.findByTotal", query = "SELECT t FROM TourTicket t WHERE t.total = :total")})
public class TourTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_payment")
    private boolean isPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private long total;
    @JoinColumn(name = "surcharge_id", referencedColumnName = "id")
    @ManyToOne
    private Surcharge surchargeId;
    @JoinColumn(name = "tour_booking_id", referencedColumnName = "id")
    @ManyToOne
    private TourBooking tourBookingId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne
    private User employeeId;

    public TourTicket() {
    }

    public TourTicket(Integer id) {
        this.id = id;
    }

    public TourTicket(Integer id, String type, long price, boolean isPayment, long total) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.isPayment = isPayment;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(boolean isPayment) {
        this.isPayment = isPayment;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Surcharge getSurchargeId() {
        return surchargeId;
    }

    public void setSurchargeId(Surcharge surchargeId) {
        this.surchargeId = surchargeId;
    }

    public TourBooking getTourBookingId() {
        return tourBookingId;
    }

    public void setTourBookingId(TourBooking tourBookingId) {
        this.tourBookingId = tourBookingId;
    }

    public User getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(User employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourTicket)) {
            return false;
        }
        TourTicket other = (TourTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lth.pojos.TourTicket[ id=" + id + " ]";
    }
    
}
