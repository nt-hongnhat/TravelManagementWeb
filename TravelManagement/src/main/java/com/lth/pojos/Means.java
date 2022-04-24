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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "means")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Means.findAll", query = "SELECT m FROM Means m"),
    @NamedQuery(name = "Means.findById", query = "SELECT m FROM Means m WHERE m.id = :id"),
    @NamedQuery(name = "Means.findByName", query = "SELECT m FROM Means m WHERE m.name = :name"),
    @NamedQuery(name = "Means.findByType", query = "SELECT m FROM Means m WHERE m.type = :type"),
    @NamedQuery(name = "Means.findByStatus", query = "SELECT m FROM Means m WHERE m.status = :status"),
    @NamedQuery(name = "Means.findByCapacity", query = "SELECT m FROM Means m WHERE m.capacity = :capacity")})
public class Means implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private int capacity;
    @OneToMany(mappedBy = "meansId")
    private Collection<Transport> transportCollection;

    public Means() {
    }

    public Means(Integer id) {
        this.id = id;
    }

    public Means(Integer id, String name, String type, String status, int capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public Collection<Transport> getTransportCollection() {
        return transportCollection;
    }

    public void setTransportCollection(Collection<Transport> transportCollection) {
        this.transportCollection = transportCollection;
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
        if (!(object instanceof Means)) {
            return false;
        }
        Means other = (Means) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lth.pojos.Means[ id=" + id + " ]";
    }
    
}
