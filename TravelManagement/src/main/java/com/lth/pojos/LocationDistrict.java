package com.lth.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "LocationDistrict")
@Table(name = "location_district", indexes = {
        @Index(name = "fk_district_province_idx", columnList = "province_id")
})
public class LocationDistrict implements Serializable {
    private static final long serialVersionUID = 4970873884444247218L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private LocationProvince province;

    @OneToMany(mappedBy = "district")
    private Set<Location> locations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "district")
    private Set<LocationWard> locationWards = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public LocationDistrict setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocationDistrict setName(String name) {
        this.name = name;
        return this;
    }

    public LocationProvince getProvince() {
        return province;
    }

    public LocationDistrict setProvince(LocationProvince province) {
        this.province = province;
        return this;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public LocationDistrict setLocations(Set<Location> locations) {
        this.locations = locations;
        return this;
    }

    public Set<LocationWard> getLocationWards() {
        return locationWards;
    }

    public LocationDistrict setLocationWards(Set<LocationWard> locationWards) {
        this.locationWards = locationWards;
        return this;
    }

}