package com.mphasis.main.cui;

public class Airplane extends Vehicle implements Flyer{

    @Override
    public void takeOff() {
        System.out.println("Airplane takeOff");
    }

    @Override
    public void fly() {
        System.out.println("Airplane fly");
    }

    @Override
    public void land() {
        System.out.println("Airplane land");
    }
}
