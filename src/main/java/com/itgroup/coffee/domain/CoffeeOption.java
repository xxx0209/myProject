package com.itgroup.coffee.domain;

public enum CoffeeOption {

    HOT("핫", "HOT"),
    ICED("아이스", "ICED");

    private final String name;
    private final String code;

    // 생성자
    CoffeeOption(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name + "[" + code + "]";
    }

}
