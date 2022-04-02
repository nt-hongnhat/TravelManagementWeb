package com.lth.pojos;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employee", indexes = {
        @Index(name = "fk_employee_location_idx", columnList = "location_id")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private GenderType gender;

    private Instant birthday;

    private Integer citizenship;

    private Integer phone;

    private Location location;

    private String address;

    private Set<TourTicket> tourTickets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    public Set<TourTicket> getTourTickets() {
        return tourTickets;
    }

    public void setTourTickets(Set<TourTicket> tourTickets) {
        this.tourTickets = tourTickets;
    }

    @Column(name = "address", length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Column(name = "citizenship", nullable = false)
    public Integer getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Integer citizenship) {
        this.citizenship = citizenship;
    }

    @Column(name = "birthday", nullable = false)
    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    @Column(name = "name", nullable = false, length = 50)
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