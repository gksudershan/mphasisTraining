package com.mphasis.main.cui;

import java.util.*;

class Address{
    private String name;
    private String street;
    private String city;
    private String state;
    private String code;

    public Address(String name, String street, String city, String state, String code) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + "\n" +
                ", street='" + street + "\n" +
                ", city='" + city + "\n" +
                ", state='" + state + "\n" +
                ", code='" + code + "\n" +
                '}';
    }
}

class MyComp implements Comparator<String> {
    public int compare(String a, String b) {
        String aStr, bStr;

        aStr = a;
        bStr = b;

        // Reverse the comparison.
        return bStr.compareTo(aStr);
    }

    // No need to override equals.
}

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
        System.out.println();

        //Modify objects being iterated.
        ListIterator<String> listIterator = al.listIterator();
        while(listIterator.hasNext()){
            String temp = listIterator.next();
            listIterator.set(temp+"+");
        }

        System.out.println("Modified contents of al: ");
        iterator = al.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element+" ");
        }
        System.out.println();

        //Now, display the list backwards.
        System.out.println("Modified list backwards: ");
        while(listIterator.hasPrevious()){
            String element = listIterator.previous();
            System.out.println(element+" ");
        }
        System.out.println();

        LinkedList<Address> ml = new LinkedList<Address>();

        //Add elements to the linked list.
        ml.add(new Address("J.W. West", "11 Oak Ave",
                "Urbana", "IL", "61801"));
        ml.add(new Address("Ralph Baker", "1142 Maple Lane",
                "Mahome", "IL", "61853"));
        ml.add(new Address("Tom Carlton", "867 Elm St",
                "Champaign", "IL", "61820"));

        // Display the mailing list.
        for(Address element : ml)
            System.out.println(element + "\n");

        System.out.println();

        TreeSet<String> ts = new TreeSet<String>(new MyComp());

        // Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        // Display the elements.
        for(String element : ts)
            System.out.print(element + " ");

        System.out.println();

        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);

        // Create a reverse order comparator.
        Comparator<Integer> r = Collections.reverseOrder();

        // Sort list by using the comparator.
        Collections.sort(ll, r);

        System.out.print("List sorted in reverse: ");
        for(int i : ll)
            System.out.print(i+ " ");

        System.out.println();

        // Shuffle list.
        Collections.shuffle(ll);

        // Display randomized list.
        System.out.print("List shuffled: ");
        for(int i : ll)
            System.out.print(i + " ");

        System.out.println();

        System.out.println("Minimum: " + Collections.min(ll));
        System.out.println("Maximum: " + Collections.max(ll));
    }
}
