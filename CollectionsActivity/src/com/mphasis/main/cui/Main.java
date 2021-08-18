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

        // Allocate and initialize array.
        int array[] = new int[10];
        for(int i = 0; i < 10; i++)
            array[i] = -3 * i;

        // Display, sort, and display the array.
        System.out.print("Original contents: ");
        display(array);
        Arrays.sort(array);
        System.out.print("Sorted: ");
        display(array);

        // Fill and display the array.
        Arrays.fill(array, 2, 6, -1);
        System.out.print("After fill(): ");
        display(array);

        // Sort and display the array.
        Arrays.sort(array);
        System.out.print("After sorting again: ");
        display(array);

        // Binary search for -9.
        System.out.print("The value -9 is at location ");
        int index =
                Arrays.binarySearch(array, -9);

        System.out.println(index);
        System.out.println();

        ArrayList list = new ArrayList();

        // These lines store strings, but any type of object
        // can be stored.  In old-style code, there is no
        // convenient way restrict the type of objects stored
        // in a collection
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Iterator itr = list.iterator();
        while(itr.hasNext()) {

            // To retrieve an element, an explicit type cast is needed
            // because the collection stores only Object.
            String str = (String) itr.next(); // explicit cast needed here.

            System.out.println(str + " is " + str.length() + " chars long.");
        }
            Vector<Integer> vector = new Vector<>(3,2);
            System.out.println("Initial size: "+ vector.size());
            System.out.println("Initial capacity: "+vector.capacity());

            vector.add(1);
            vector.add(2);
            vector.add(3);
            vector.add(4);

            System.out.println("Capacity after four additions: "+vector.capacity());
            vector.add(5);
            System.out.println("Current capacity: "+vector.capacity());
            vector.add(6);
            vector.add(7);

            System.out.println("Current capacity: "+vector.capacity());
            vector.add(9);
            vector.add(10);

            System.out.println("Current capacity: "+vector.capacity());
            vector.add(11);
            vector.add(12);

            System.out.println("First element: " + vector.firstElement());
            System.out.println("Last element: " + vector.lastElement());

            if(vector.contains(3)){
                System.out.println("Collection contains 3");
            }

            System.out.println("Elements in collections: ");
            Iterator iterator1 = vector.iterator();
            while(iterator1.hasNext()){
                System.out.println(iterator1.next()+" ");
            }
            System.out.println();

        }

    public static void display(int array[]) {
        for(int i: array)
            System.out.print(i + " ");

        System.out.println();
    }
}
