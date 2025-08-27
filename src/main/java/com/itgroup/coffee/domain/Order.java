package com.itgroup.coffee.domain;

import com.itgroup.coffee.domain.CoffeeMenu;
import com.itgroup.coffee.domain.CoffeeOption;
import com.itgroup.coffee.domain.OrderStep;

public class Order {

    private String id;
    private int quantity;
    private CoffeeMenu coffeeMenu;
    private CoffeeOption coffeeOption;
    private OrderStep orderStep;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public OrderStep getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(OrderStep orderStep) {
        this.orderStep = orderStep;
    }
}
