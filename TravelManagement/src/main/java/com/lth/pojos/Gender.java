package com.lth.pojos;

public enum Gender {
    MALE("Nam"), FEMALE("Nữ"), OTHER("Khác");
    private String content;

    public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
        return Enum.valueOf(enumType, name);
    }

    @Override
    public String toString() {
        return this.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    Gender(String content) {
        this.content = content;
    }
}
