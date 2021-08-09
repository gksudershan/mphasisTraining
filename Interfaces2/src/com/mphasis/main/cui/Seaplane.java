package com.mphasis.main.cui;

public class Seaplane extends Airplane implements Sailor{
    @Override
    public void takeOff() {
        System.out.println("Seaplane takeOff");
    }

    @Override
    public void fly() {
        System.out.println("Seaplane fly");
    }

    @Override
    public void land() {
        System.out.println("Seaplane land");
    }

    @Override
    public void dock() {
        System.out.println("Seaplane dock");
    }

    @Override
    public void cruise() {
        System.out.println("Seaplane cruise");
    }
}
