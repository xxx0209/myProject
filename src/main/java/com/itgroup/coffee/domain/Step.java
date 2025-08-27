package com.itgroup.coffee.domain;

public class Step {
    private OrderStep orderStep;
    private MoreStep moreStep;

    public OrderStep getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(OrderStep orderStep) {
        this.orderStep = orderStep;
    }

    public MoreStep getMoreStep() {
        return moreStep;
    }

    public void setMoreStep(MoreStep moreStep) {
        this.moreStep = moreStep;
    }
}
