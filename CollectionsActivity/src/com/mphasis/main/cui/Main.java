package com.mphasis.main.cui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        LinkedList<String> result = new LinkedList<String>();

        result.add("B");
        result.add("C");
        result.add("D");
        result.add("X");
        result.add("Y");
        result.add("Z");
        result.add("A");

        result.add(1,"A2");

        System.out.println("Original contents of result:"+result);

        //Remove elements from the collection
        result.remove("F");
        result.remove(2);

        System.out.println("Contents of result after deletion: "+result);

        result.removeFirst();
        result.removeLast();

        System.out.println("result after deleting first and last: "+result);

        //Get and set a value
        String val = result.get(2);
        result.set(2,val+"Changed");

        System.out.println("result after change: "+result);

        ArrayList<String> al = new ArrayList<String>();

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        //iterate through the list
        System.out.println("Original contents of al");
        Iterator<String> iterator = al.iterator();
        while(iterator.hasNext()){
            String temp = iterator.next();
            System.out.println(temp);
        }

    }
}
