package com.itgroup.cofee.domain;

public class Order {

    private String orderId;
    private int seq;
    private String memberId;
    private CoffeeMenu drinkName;
    private CoffeeOption drinkOption;
    private int quantity;
    private int price;
    private String orderDate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public CoffeeMenu getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(CoffeeMenu drinkName) {
        this.drinkName = drinkName;
    }

    public CoffeeOption getDrinkOption() {
        return drinkOption;
    }

    public void setDrinkOption(CoffeeOption drinkOption) {
        this.drinkOption = drinkOption;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
