/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "tour_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourBooking.findAll", query = "SELECT t FROM TourBooking t"),
    @NamedQuery(name = "TourBooking.findById", query = "SELECT t FROM TourBooking t WHERE t.id = :id"),
    @NamedQuery(name = "TourBooking.findByBookingDate", query = "SELECT t FROM TourBooking t WHERE t.bookingDate = :bookingDate"),
    @NamedQuery(name = "TourBooking.findByDepartureDate", query = "SELECT t FROM TourBooking t WHERE t.departureDate = :departureDate"),
    @NamedQuery(name = "TourBooking.findByDepartureAddress", query = "SELECT t FROM TourBooking t WHERE t.departureAddress = :departureAddress"),
    @NamedQuery(name = "TourBooking.findByQuantityAdults", query = "SELECT t FROM TourBooking t WHERE t.quantityAdults = :quantityAdults"),
    @NamedQuery(name = "TourBooking.findByQuantityChildren", query = "SELECT t FROM TourBooking t WHERE t.quantityChildren = :quantityChildren")})
public class TourBooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "booking_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departure_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Size(max = 45)
    @Column(name = "departure_address")
    private String departureAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity_adults")
    private int quantityAdults;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity_children")
    private int quantityChildren;
    @OneToMany(mappedBy = "tourBookingId")
    private Collection<TourTicket> tourTicketCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "departure_location_id", referencedColumnName = "id")
    @ManyToOne
    private Location departureLocationId;
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    @ManyToOne
    private Tour tourId;

    public TourBooking() {
    }

    public TourBooking(Integer id) {
        this.id = id;
    }

    public TourBooking(Integer id, Date bookingDate, Date departureDate, int quantityAdults, int quantityChildren) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.departureDate = departureDate;
        this.quantityAdults = quantityAdults;
        this.quantityChildren = quantityChildren;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureAddress() {
        return departureAddress;
    }

    public void setDepartureAddress(String departureAddress) {
        this.departureAddress = departureAddress;
    }

    public int getQuantityAdults() {
        return quantityAdults;
    }

    public void setQuantityAdults(int quantityAdults) {
        this.quantityAdults = quantityAdults;
    }

    public int getQuantityChildren() {
        return quantityChildren;
    }

    public void setQuantityChildren(int quantityChildren) {
        this.quantityChildren = quantityChildren;
    }

    @XmlTransient
    public Collection<TourTicket> getTourTicketCollection() {
        return tourTicketCollection;
    }

    public void setTourTicketCollection(Collection<TourTicket> tourTicketCollection) {
        this.tourTicketCollection = tourTicketCollection;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Location getDepartureLocationId() {
        return departureLocationId;
    }

    public void setDepartureLocationId(Location departureLocationId) {
        this.departureLocationId = departureLocationId;
    }

    public Tour getTourId() {
        return tourId;
    }

    public void setTourId(Tour tourId) {
        this.tourId = tourId;
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
        if (!(object instanceof TourBooking)) {
            return false;
        }
        TourBooking other = (TourBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lth.pojos.TourBooking[ id=" + id + " ]";
    }
    
}
