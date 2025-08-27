package com.itgroup.composeCofee.domain;

public class Order {

    private String orderId;
    private String memberId;
    private String orderDate;
    private CoffeeMenu coffeeMenu;
    private CoffeeOption coffeeOption;
    private int quantity;
    private int price;
    private int stamps;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public CoffeeMenu getCoffeeMenu() {
        return coffeeMenu;
    }

    public void setCoffeeMenu(CoffeeMenu coffeeMenu) {
        this.coffeeMenu = coffeeMenu;
    }

    public CoffeeOption getCoffeeOption() {
        return coffeeOption;
    }

    public void setCoffeeOption(CoffeeOption coffeeOption) {
        this.coffeeOption = coffeeOption;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStamps() {
        return stamps;
    }

    public void setStamps(int stamps) {
        this.stamps = stamps;
    }
}
