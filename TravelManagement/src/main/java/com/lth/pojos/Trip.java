/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.pojos;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "trip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t"),
    @NamedQuery(name = "Trip.findById", query = "SELECT t FROM Trip t WHERE t.id = :id")})
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "trip")
    private Collection<Tour> tourCollection;
    @JoinColumn(name = "departure_province_id", referencedColumnName = "id")
    @ManyToOne
    private Province departureProvinceId;
    @JoinColumn(name = "destination_province_id", referencedColumnName = "id")
    @ManyToOne
    private Province destinationProvinceId;

    public Trip() {
    }

    public Trip(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Tour> getTourCollection() {
        return tourCollection;
    }

    public void setTourCollection(Collection<Tour> tourCollection) {
        this.tourCollection = tourCollection;
    }

    public Province getDepartureProvinceId() {
        return departureProvinceId;
    }

    public void setDepartureProvinceId(Province departureProvinceId) {
        this.departureProvinceId = departureProvinceId;
    }

    public Province getDestinationProvinceId() {
        return destinationProvinceId;
    }

    public void setDestinationProvinceId(Province destinationProvinceId) {
        this.destinationProvinceId = destinationProvinceId;
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
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lth.pojos.Trip[ id=" + id + " ]";
    }
    
}
