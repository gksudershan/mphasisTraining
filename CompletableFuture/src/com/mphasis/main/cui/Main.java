package com.mphasis.main.cui;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Begin");
        //create().thenAccept((data)-> print(data))
        //.thenRun(()-> System.out.println(2));
        //CompletableFuture<Integer> cFuture = new CompletableFuture<>();
        CompletableFuture<Integer> cFuture = create();
        //cFuture.complete(3);
        process(cFuture);

        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */

    }

    public static CompletableFuture<Integer> create(){
        System.out.println("Inside main: " + Thread.currentThread());
        return CompletableFuture.supplyAsync(()->compute());
    }

    public static int compute(){
        System.out.println("Inside compute: " + Thread.currentThread());
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return 2;
    }

    public static void print(Integer data){
        System.out.println(Thread.currentThread());
        System.out.println(data);
    }

    public static void process(CompletableFuture<Integer> cFuture){
        System.out.println("inside process: "+Thread.currentThread());
        cFuture.thenApply((data)->data*2)
                .thenApply(data->data/0)
                .exceptionally(throwable -> handle(throwable))
                .thenApply(data->Integer.parseInt("2O"))
                .exceptionally(throwable -> handle(throwable) )
                .thenAccept(data->print(data))
                .thenRun(()-> System.out.println(1))
                .thenRun(()-> System.out.println(2))
                .thenRun(()-> System.out.println(3));
    }

    public static int handle(Throwable throwable){
        System.out.println(throwable.fillInStackTrace());
        return 2;
    }
}
