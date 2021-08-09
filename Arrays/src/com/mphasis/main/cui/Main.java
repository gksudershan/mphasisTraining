package com.mphasis.main.cui;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
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
        //One dimensional array
        int nums[] = null;

        nums = new int[5];

        nums[2]=1;
        nums[4]=8;

        for(int counter=0;counter<nums.length;counter++)
        {
            System.out.println(nums[counter]);
        }

        for(int num:nums){
            System.out.println(num);
        }

        // two dimensional array
        int nums2[][] = null;

        nums2 = new int[5][3];

        nums2[2][1] = 1;
        nums2[4][1] = 8;

        for(int[] num1:nums2){
            for(int num2:num1){
                System.out.println(num2);
            }
        }

        // Reference arrays
        Point[] points = null;

        points = new Point[5];

        points[2] = new Point(2,3);
        points[4] = new Point(4,3);

        for(Point point:points){
            System.out.println(point);
        }
    }
}
