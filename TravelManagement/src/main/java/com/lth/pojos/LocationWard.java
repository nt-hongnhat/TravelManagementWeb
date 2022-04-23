package com.lth.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "LocationWard")
@Table(name = "location_ward", indexes = {
        @Index(name = "fk_ward_district_idx", columnList = "district_id"),
        @Index(name = "fk_ward_province_idx", columnList = "province_id")
})
public class LocationWard implements Serializable {
    private static final long serialVersionUID = 1656973670966037133L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private LocationDistrict district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private LocationProvince province;

    @OneToMany(mappedBy = "ward")
    private Set<Location> locations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public LocationWard setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocationWard setName(String name) {
        this.name = name;
        return this;
    }

    public LocationDistrict getDistrict() {
        return district;
    }

    public LocationWard setDistrict(LocationDistrict district) {
        this.district = district;
        return this;
    }

    public LocationProvince getProvince() {
        return province;
    }

    public LocationWard setProvince(LocationProvince province) {
        this.province = province;
        return this;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public LocationWard setLocations(Set<Location> locations) {
        this.locations = locations;
        return this;
    }

}