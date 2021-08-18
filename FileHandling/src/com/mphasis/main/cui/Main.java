package com.mphasis.main.cui;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
        File file = new File("src/test");
        System.out.println(file.exists());

    }
}
