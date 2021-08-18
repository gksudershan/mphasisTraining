package com.mphasis.main.cui;

import sun.rmi.runtime.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

interface Printer{
    public void print(String txt);
}

interface Transformer{
    public int transform(String txt);
}

interface Logging{

    public void log(Level level, String msg);
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

        Logging logger = (Level,msg)->Logger.getLogger(Main.class.getName()).log(Level,msg);
        logger.log(Level.INFO,"Hi");
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
