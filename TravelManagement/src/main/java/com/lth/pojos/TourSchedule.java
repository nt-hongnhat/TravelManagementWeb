package com.lth.pojos;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TourSchedule")
@Table(name = "tour_schedule", indexes = {
        @Index(name = "fk_tour_program_idx", columnList = "tour_id")
})
public class TourSchedule implements Serializable {
    private static final long serialVersionUID = -1830656334025034161L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    public Integer getId() {
        return id;
    }

    public TourSchedule setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TourSchedule setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TourSchedule setDescription(String description) {
        this.description = description;
        return this;
    }

    public Tour getTour() {
        return tour;
    }

    public TourSchedule setTour(Tour tour) {
        this.tour = tour;
        return this;
    }

}