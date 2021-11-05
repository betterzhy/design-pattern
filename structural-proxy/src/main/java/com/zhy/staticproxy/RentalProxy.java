package com.zhy.staticproxy;

interface Rentable {
    void rent();
}

public class RentalProxy implements Rentable {
    private Rentable target;

    public void setTarget(Rentable target) {
        this.target = target;
    }

    @Override
    public void rent() {
        // TODO 前值增强
        this.target.rent();
        // TODO 后置增强
    }
}

class HouseRental implements Rentable {

    @Override
    public void rent() {

    }
}

class CarRental implements Rentable {

    @Override
    public void rent() {

    }
}

