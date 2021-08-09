package com.mphasis.main.cui;

public class Superman extends Kryptonian implements Flyer{
    @Override
    public void takeOff() {
        System.out.println("Superman takeOff");
    }

    @Override
    public void fly() {
        System.out.println("Superman fly");
    }

    @Override
    public void land() {
        System.out.println("Superman land");
    }

    public void leapBuilding(){
        System.out.println("Superman leapBuilding");
    }

    public void stopBullet(){
        System.out.println("Superman stopBullet");
    }
}
