package com.lth.pojos;

import javax.persistence.*;

@Entity
@Table(name = "transportation", indexes = {
        @Index(name = "pk_transportation_transport_idx", columnList = "transport_id")
})
public class Transportation {
    @EmbeddedId
    private TransportationId id;

    private Tour tour;

    private Transport transport;

    @MapsId("transportId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transport_id", nullable = false)
    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @MapsId("tourId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tour_id", nullable = false)
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public TransportationId getId() {
        return id;
    }

    public void setId(TransportationId id) {
        this.id = id;
    }
}