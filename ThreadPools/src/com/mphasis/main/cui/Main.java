package com.mphasis.main.cui;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
class Task implements Runnable{
    private static Logger logger;
    static{
        logger = Logger.getLogger(Task.class.getName());
    }
    @Override
    public void run() {
        logger.log(Level.INFO,"Task started");
        //logger.log(Level.INFO,Thread.currentThread().toString());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO,"Task ended");
    }
}

class CallableTask implements Callable<Point>{
    private static Logger logger;
    static{
        logger = Logger.getLogger(Task.class.getName());
    }
    @Override
    public Point call() throws Exception {
        logger.log(Level.INFO,"Task started");
        //logger.log(Level.INFO,Thread.currentThread().toString());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO,"Task ended");
        return new Point(2,4);
    }
}
public class Main {
    private static Logger logger;
    static{
        logger = Logger.getLogger(Main.class.getName());
    }
    public static void main(String[] args) {

	// write your code here
        int vCPUS = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(vCPUS);
        Future<Point> future = executorService.submit(new CallableTask());
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        /*for(int counter=0;counter<20;counter++){
            executorService.execute(new Task());
        }*/
        //logger.log(Level.INFO,"Begin");
        //executorService.schedule(new Task(),10, TimeUnit.SECONDS);
        //executorService.scheduleAtFixedRate(new Task(),5,10,TimeUnit.SECONDS);
        //logger.log(Level.INFO,"Submitted");
        //executorService.shutdown();

        try{
            Point point = future.get();
            System.out.println(point);
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
