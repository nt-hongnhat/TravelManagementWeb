package com.lth.pojos;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "surcharge", indexes = {
        @Index(name = "name_UNIQUE", columnList = "name", unique = true)
})
public class Surcharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private Double percentage;

    private Set<TourTicket> tourTickets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "surcharge")
    public Set<TourTicket> getTourTickets() {
        return tourTickets;
    }

    public void setTourTickets(Set<TourTicket> tourTickets) {
        this.tourTickets = tourTickets;
    }

    @Column(name = "percentage", nullable = false)
    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}