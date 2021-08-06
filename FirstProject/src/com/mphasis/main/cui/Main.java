package com.mphasis.main.cui;

class Point{
    int x;
    int y;
}

class Factory{
    public Point getInstance(){
        Point point = new Point();
        point.x = 2;
        point.y = 5;
        return point;
    }
}
public class Main {

    public static void main(String[] args) {
	Factory factory = new Factory();
	Point result = factory.getInstance();
	System.out.println(result.x+","+result.y);
    }
}
