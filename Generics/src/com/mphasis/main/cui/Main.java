package com.mphasis.main.cui;

class Point<T>{
    private T x;
    private T y;

    public Point(T x, T y){
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here

        Point<Integer> point1 = new Point(2,4);
        Point<Float> point2 = new Point(3.5f,6.5f);

    }
}
