package com.mphasis.main.cui;

import com.mphasis.entities.Point;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Point point1 = new Point(2,4);
        Point point2 = new Point(2,4);

        System.out.println(point1.equals(point2));
    }
}
