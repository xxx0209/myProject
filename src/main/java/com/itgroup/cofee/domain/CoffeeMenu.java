package com.itgroup.cofee.domain;

import java.text.DecimalFormat;

public enum CoffeeMenu {
    ESPRESSO("에스프레소", 1500),
    AMERICANO("아메리카노", 1800),
    CAFELATTE("카페라떼", 2900);

    DecimalFormat df = new DecimalFormat("#,###");
    private final String name;
    private final int price;
    private final String label;
    // 생성자
    CoffeeMenu(String name, int price) {
        this.name = name;
        this.price = price;
        this.label = name;
    }

    // Getter
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return name + "[" + df.format(price) + "원]";
    }

    public static CoffeeMenu fromDbValue(String dbValue) {
        for (CoffeeMenu d : values()) {
            if (d.name().equalsIgnoreCase(dbValue) || d.label.equals(dbValue)) {
                return d;
            }
        }
        throw new IllegalArgumentException("Unknown drink: " + dbValue);
    }
}
