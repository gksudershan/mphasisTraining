package com.mphasis.main.cui;

public interface Test {
    int value = 10;
    void test1();
    default void test2(){
        System.out.println("Test test2");
    }
    void test3();
}
