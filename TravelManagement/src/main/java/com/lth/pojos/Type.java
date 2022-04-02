package com.lth.pojos;

public enum Type {
    CARS("Ô tô"), YATCH("Du thuyền"), AIRLINES("Máy bay"), CANOEING("Xuồng chèo");
    private String name;

    private Type(String name) {
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
