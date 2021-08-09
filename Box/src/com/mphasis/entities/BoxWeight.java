package com.mphasis.entities;

public class BoxWeight extends Box{
    public double weight;

    public BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth);
        this.weight = weight;
    }

    public BoxWeight(BoxWeight ob){
        super(ob);
        this.weight = ob.weight;
    }

    public BoxWeight(){
        super();
        this.weight = -1;
    }

    public BoxWeight(double len, double weight){
        super(len);
        this.weight = weight;
    }


}
