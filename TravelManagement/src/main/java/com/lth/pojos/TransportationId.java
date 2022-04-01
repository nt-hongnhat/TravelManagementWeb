package com.lth.pojos;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TransportationId implements Serializable {
    private static final long serialVersionUID = 6639712017660276593L;
    @Column(name = "tour_id", nullable = false)
    private Integer tourId;
    @Column(name = "transport_id", nullable = false)
    private Integer transportId;

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transportId, tourId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TransportationId entity = (TransportationId) o;
        return Objects.equals(this.transportId, entity.transportId) &&
                Objects.equals(this.tourId, entity.tourId);
    }
}