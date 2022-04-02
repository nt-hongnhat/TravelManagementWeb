package com.lth.pojos;

public enum StatusType {
    AVAILABLE("Đang sẵn dùng"), REPAIRING("Đang sửa chữa"), USING("Đang sử dụng");
    private String name;

    private StatusType(String name) {
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
