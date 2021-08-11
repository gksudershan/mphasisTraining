package com.mphasis.main.cui;

import java.util.logging.Level;
import java.util.logging.Logger;

class Data{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Task implements Runnable{
    Thread firstThread;
    Data data;
    private static Logger logger;
    static{
        logger = Logger.getLogger(Task.class.getName());
    }
    Task(){
        data = new Data();
    }
    @Override
    public void run() {
        Thread currThread = Thread.currentThread();
       /* if (currThread.getName().equals("Thread1")){
            firstThread = currThread;
        }

        if(currThread.getName().equals("Thread2")){
            if (firstThread!=null){
                try{
                    printInfo("Thread2 joins==========Thread1");
                    firstThread.join();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        */

        for(int count=0;count<10;count++){
            if (currThread.getName().equals("Producer")){
                printInfo(currThread.toString());
                synchronized (data){        //attempt to acquire the lock
                    data.setValue(count);
                }// release the lock automatically
            }else if (currThread.getName().equals("Consumer")){
                synchronized (data){
                    printInfo(currThread+String.valueOf(data.getValue()));
                }
            }
        }

    }
    private static void printInfo(String msg){
        logger.log(Level.INFO,msg);
    }
}

public class Main {
    private static Logger logger;
    static{
        logger = Logger.getLogger(Main.class.getName());
    }
    public static void main(String[] args) {
	// write your code here
       // printInfo(String.valueOf(Runtime.getRuntime().availableProcessors()));
        Thread mainThread = Thread.currentThread();
        printInfo(mainThread.toString());
        printInfo(mainThread.getState().toString());
        Task task = new Task();
        Thread thread1 = new Thread(task,"Consumer");
        Thread thread2 = new Thread(task,"Producer");

        printInfo(thread1.toString());
        printInfo(thread1.toString() +" " + thread1.getState().toString());

        thread1.start();
        thread2.start();
        printInfo("Thread1 is ==========>"+" " + thread1.getState().toString());
        printInfo("Thread2 is ==========>"+" " + thread2.getState().toString());
        try{
           //mainThread.sleep(1);
           //printInfo(mainThread.getState().toString());
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        printInfo(thread1.getName() + " " + thread1.getState().toString());
        printInfo(thread2.getName() + " " + thread2.getState().toString());
        printInfo("End");
    }

    private static void printInfo(String msg){
        logger.log(Level.INFO,msg);
    }
}
