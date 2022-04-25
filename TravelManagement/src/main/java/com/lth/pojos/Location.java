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
 * @author PC
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
        @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "location")
    private Collection<UserInfo> userInfoCollection;
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    @ManyToOne
    private District districtId;
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    @ManyToOne
    private Province provinceId;
    @JoinColumn(name = "ward_id", referencedColumnName = "id")
    @ManyToOne
    private Ward wardId;
    @OneToMany(mappedBy = "locationId")
    private Collection<Place> placeCollection;

    public Location() {
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public Collection<UserInfo> getUserInfoCollection() {
        return userInfoCollection;
    }

    public void setUserInfoCollection(Collection<UserInfo> userInfoCollection) {
        this.userInfoCollection = userInfoCollection;
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    public Province getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Province provinceId) {
        this.provinceId = provinceId;
    }

    public Ward getWardId() {
        return wardId;
    }

    public void setWardId(Ward wardId) {
        this.wardId = wardId;
    }

    @XmlTransient
    public Collection<Place> getPlaceCollection() {
        return placeCollection;
    }

    public void setPlaceCollection(Collection<Place> placeCollection) {
        this.placeCollection = placeCollection;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lth.pojos.Location[ id=" + id + " ]";
    }

}
