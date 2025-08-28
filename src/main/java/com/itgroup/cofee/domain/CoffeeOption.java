package com.itgroup.cofee.domain;

public enum CoffeeOption {

    HOT("핫", "HOT"),
    ICED("아이스", "ICED");

    private final String name;
    private final String code;
    private final String label;

    // 생성자
    CoffeeOption(String name, String code) {
        this.name = name;
        this.code = code;
        this.label = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static CoffeeOption fromDbValue(String dbValue) {
        for (CoffeeOption d : values()) {
            if (d.name().equalsIgnoreCase(dbValue) || d.label.equals(dbValue)) {
                return d;
            }
        }
        throw new IllegalArgumentException("Unknown drink: " + dbValue);
    }

    @Override
    public String toString() {
        return name + "[" + code + "]";
    }

}
