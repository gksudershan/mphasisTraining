package com.mphasis.entities;

public class Box {
    double width;
    double height;
    double depth;

    // construct clone of an object
    public Box(Box ob){

    }

    // constructor used when all dimensions specified
    public Box(double width, double height, double depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box(){
        width=-1;
        height=-1;
        depth=-1;
    }

    Box(double len){
        width = height = depth = len;
    }

    double volume(){
        return width*height*depth;
    }
}
