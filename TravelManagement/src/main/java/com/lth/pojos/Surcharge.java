/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "surcharge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surcharge.findAll", query = "SELECT s FROM Surcharge s"),
    @NamedQuery(name = "Surcharge.findById", query = "SELECT s FROM Surcharge s WHERE s.id = :id"),
    @NamedQuery(name = "Surcharge.findByName", query = "SELECT s FROM Surcharge s WHERE s.name = :name"),
    @NamedQuery(name = "Surcharge.findByPercentage", query = "SELECT s FROM Surcharge s WHERE s.percentage = :percentage")})
public class Surcharge implements Serializable {

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
    @Column(name = "percentage")
    private float percentage;

    public Surcharge() {
    }

    public Surcharge(Integer id) {
        this.id = id;
    }

    public Surcharge(Integer id, String name, float percentage) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
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

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
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
        if (!(object instanceof Surcharge)) {
            return false;
        }
        Surcharge other = (Surcharge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lth.pojos.Surcharge[ id=" + id + " ]";
    }
    
}
