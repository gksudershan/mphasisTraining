package com.mphasis.main.cui;

interface Printer{
    public void print(String txt);
}

interface Transformer{
    public int transform(String txt);
}
public class Main {

    public static void main(String[] args) {
	// write your code here

        Printer printer1 = new Printer() {
            @Override
            public void print(String txt) {
                System.out.println(txt);
            }
        };
        printer1.print("Bangalore");

        Printer printer2 = (txt)-> System.out.println(txt);
        printer2.print("Mphasis");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        }).start();

        new Thread(()-> System.out.println(Thread.currentThread())).start();

        Transformer transformer = Integer::valueOf;
        int result = transformer.transform("12");

        System.out.println(result);
    }
}
