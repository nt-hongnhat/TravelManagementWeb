package com.lth.pojos;

public enum GenderType {
    MALE("Nam"), FEMALE("Nữ"), OTHER("Khác");
    private String name;

    private GenderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
