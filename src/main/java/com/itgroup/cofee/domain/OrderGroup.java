package com.itgroup.cofee.domain;

public class OrderGroup {

    private String orderId;
    private String recentDate;
    private int totalPrice;
    private int orderCount;
    private CoffeeMenu lastDrink;
    private CoffeeOption lastOption;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRecentDate() {
        return recentDate;
    }

    public void setRecentDate(String recentDate) {
        this.recentDate = recentDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public CoffeeMenu getLastDrink() {
        return lastDrink;
    }

    public void setLastDrink(CoffeeMenu lastDrink) {
        this.lastDrink = lastDrink;
    }

    public CoffeeOption getLastOption() {
        return lastOption;
    }

    public void setLastOption(CoffeeOption lastOption) {
        this.lastOption = lastOption;
    }
}
