package com.mphasis.main.cui;

public class RiverBarge extends Vehicle implements Sailor{

    @Override
    public void dock() {
        System.out.println("RiverBarge dock");
    }

    @Override
    public void cruise() {
        System.out.println("RiverBarge cruise");
    }
}
