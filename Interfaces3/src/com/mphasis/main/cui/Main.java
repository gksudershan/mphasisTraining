package com.mphasis.main.cui;

class Testing implements Test{

    @Override
    public void test1() {
        System.out.println("Testing test1");
    }

    @Override
    public void test3() {
        System.out.println("Testing test3");
    }
}
public class Main {

    public static void main(String[] args) {
        Testing testing = new Testing();
        testing.test1();
        testing.test2();
        testing.test3();
    }
}
