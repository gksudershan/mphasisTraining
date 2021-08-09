package com.mphasis.entities;

public class Box {
    public double width;
    public double height;
    public double depth;

    // construct clone of an object
    public Box(Box ob){
        this.width = ob.width;
        this.height = ob.height;
        this.depth = ob.depth;
    }

    // constructor used when all dimensions specified
    public Box(double width, double height, double depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box(){
        this.width=-1;
        this.height=-1;
        this.depth=-1;
    }

    public Box(double len){
        width = height = depth = len;
    }

    public double volume(){
        return width*height*depth;
    }
}
