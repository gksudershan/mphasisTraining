package com.mphasis.main.cui;

public class Helicopter extends Airplane{
    @Override
    public void takeOff() {
        System.out.println("Helicopter takeOff");
    }

    @Override
    public void fly() {
        System.out.println("Helicopter fly");
    }

    @Override
    public void land() {
        System.out.println("Helicopter land");
    }
}
