package com.lth.pojos;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer", indexes = {
        @Index(name = "fk_customer_location_idx", columnList = "location_id"),
        @Index(name = "fk_customer_user_idx", columnList = "user_id")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private GenderType gender;

    private Integer citizenship;

    private Integer phone;

    private Location location;

    private String address;

    private User user;

    private Set<TourBooking> tourBookings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    public Set<TourBooking> getTourBookings() {
        return tourBookings;
    }

    public void setTourBookings(Set<TourBooking> tourBookings) {
        this.tourBookings = tourBookings;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Column(name = "phone", nullable = false)
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