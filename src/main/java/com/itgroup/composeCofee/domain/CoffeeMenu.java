package com.itgroup.composeCofee.domain;

public enum CoffeeMenu {
    ESPRESSO("에스프레소", 1500),
    AMERICANO("아메리카노", 1800),
    CAFELATTE("카페라떼", 2900);

    private final String name;
    private final int price;

    // 생성자
    CoffeeMenu(String name, int price) {
        this.name = name;
        this.price = price;
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
        return name + "[" + price + "원]";
    }
}
