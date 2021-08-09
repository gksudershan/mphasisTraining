package com.mphasis.entities;

public class BoxWeight extends Box{
    double weight;

    public BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth);
        this.weight = weight;
    }
}
