package com.mphasis.main.cui;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String string1 = new String("First");
        String string2 = new String("First");
        System.out.println(string1==string2); //compares objects
        System.out.println(string1.equals(string2)); //compares data
    }
}
