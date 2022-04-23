package com.lth.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "LocationProvince")
@Table(name = "location_province", indexes = {
        @Index(name = "name_UNIQUE", columnList = "name", unique = true)
})
public class LocationProvince implements Serializable {
    private static final long serialVersionUID = 4876274339564396855L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @OneToMany(mappedBy = "province")
    private Set<Location> locations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "departureProvince")
    private Set<Trip> trips_departure = new LinkedHashSet<>();

    @OneToMany(mappedBy = "destinationProvince")
    private Set<Trip> trips = new LinkedHashSet<>();

    @OneToMany(mappedBy = "province")
    private Set<LocationWard> locationWards = new LinkedHashSet<>();

    @OneToMany(mappedBy = "province")
    private Set<LocationDistrict> locationDistricts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public LocationProvince setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocationProvince setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public LocationProvince setLocations(Set<Location> locations) {
        this.locations = locations;
        return this;
    }

    public Set<Trip> getTrips_departure() {
        return trips_departure;
    }

    public LocationProvince setTrips_departure(Set<Trip> trips_departure) {
        this.trips_departure = trips_departure;
        return this;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public LocationProvince setTrips(Set<Trip> trips) {
        this.trips = trips;
        return this;
    }

    public Set<LocationWard> getLocationWards() {
        return locationWards;
    }

    public LocationProvince setLocationWards(Set<LocationWard> locationWards) {
        this.locationWards = locationWards;
        return this;
    }

    public Set<LocationDistrict> getLocationDistricts() {
        return locationDistricts;
    }

    public LocationProvince setLocationDistricts(Set<LocationDistrict> locationDistricts) {
        this.locationDistricts = locationDistricts;
        return this;
    }

}