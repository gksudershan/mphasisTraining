package com.mphasis.math;

public class Arithmetic {

    public int sum(int iNum1, int iNum2){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return iNum1 + iNum2;

    }
}
