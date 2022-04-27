/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "duration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Duration.findAll", query = "SELECT d FROM Duration d"),
    @NamedQuery(name = "Duration.findById", query = "SELECT d FROM Duration d WHERE d.id = :id"),
    @NamedQuery(name = "Duration.findByQuantityDays", query = "SELECT d FROM Duration d WHERE d.quantityDays = :quantityDays"),
    @NamedQuery(name = "Duration.findByQuantityNights", query = "SELECT d FROM Duration d WHERE d.quantityNights = :quantityNights")})
public class Duration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity_days")
    private int quantityDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity_nights")
    private int quantityNights;
    @OneToMany(mappedBy = "durationId")
    private Collection<Tour> tourCollection;

    public Duration() {
    }

    public Duration(Integer id) {
        this.id = id;
    }

    public Duration(Integer id, int quantityDays, int quantityNights) {
        this.id = id;
        this.quantityDays = quantityDays;
        this.quantityNights = quantityNights;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantityDays() {
        return quantityDays;
    }

    public void setQuantityDays(int quantityDays) {
        this.quantityDays = quantityDays;
    }

    public int getQuantityNights() {
        return quantityNights;
    }

    public void setQuantityNights(int quantityNights) {
        this.quantityNights = quantityNights;
    }

    @XmlTransient
    public Collection<Tour> getTourCollection() {
        return tourCollection;
    }

    public void setTourCollection(Collection<Tour> tourCollection) {
        this.tourCollection = tourCollection;
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
        if (!(object instanceof Duration)) {
            return false;
        }
        Duration other = (Duration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ngày: " + quantityDays + ", Đêm: " + quantityNights;
    }
    
}
