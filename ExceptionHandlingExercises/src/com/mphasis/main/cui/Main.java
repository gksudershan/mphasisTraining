package com.mphasis.main.cui;

import java.util.Random;

class HandleException{
    int a=0,b=0,c=0;
    Random r = new Random();

}
public class Main {

    public static void main(String[] args) {
	// write your code here
        int a=0,b=0,c=0;
        Random r = new Random();

        for(int i=0;i<32000;i++){

            b = r.nextInt();
            c = r.nextInt();

            try{
                a = 12345 / (b/c);
            }catch(ArithmeticException e){

            }

            a = 0;
        }
    }
}
