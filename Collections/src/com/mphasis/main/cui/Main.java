package com.mphasis.main.cui;

import java.util.*;

class Point{
    private int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
class Process{


    public Collection<String> getElements(){
        List<String> list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        return list;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Process process = new Process();
        Collection<String> result = process.getElements();

        /*for(String string:result){
            System.out.println(string);
        }*/

        /*Iterator<String> iterator =  result.iterator();
        for (Iterator<String> it = iterator; it.hasNext(); ) {
            String string = it.next();
            System.out.println(string);
        }

         */
        if(result instanceof List){
            List<String > list = (List) result;
            ListIterator<String> listIterator = list.listIterator();

            while(listIterator.hasNext()){
                System.out.println(listIterator.next());
            }
            System.out.println();
            while(listIterator.hasPrevious()){
                System.out.println(listIterator.previous());
            }
        }

       /* HashSet<Point> hashSet = new HashSet<Point>();

        hashSet.add(new Point(2,4));
        hashSet.add(new Point(2,4));
        hashSet.add(new Point(2,4));

        System.out.println(hashSet);

        */

        HashMap<String,Integer> paymentDetails = new HashMap<String,Integer>();
        paymentDetails.put("Joe",21332);
        paymentDetails.put("Mathew",13455);
        paymentDetails.put("David",18000);

        Integer res = paymentDetails.get("Joe");
        Set<Map.Entry<String,Integer>> allDetails = paymentDetails.entrySet();
        System.out.println(paymentDetails.entrySet());
        Iterator<Map.Entry<String,Integer>> iterator = allDetails.iterator();
        for (Map.Entry a:paymentDetails.entrySet()
             ) {
            System.out.println(a);

        }
        while(iterator.hasNext()){
            Map.Entry keyValue = iterator.next();
            System.out.println("key: "+keyValue.getKey()+","+"value: "+keyValue.getValue());
        }
        Iterator<String> iterator1 = paymentDetails.keySet().iterator();
        Iterator<Integer> iterator2 = paymentDetails.values().iterator();
        while(iterator1.hasNext()){
            String key =  iterator1.next();
            int value = iterator2.next();
            System.out.println("key: "+key+","+"value: "+value);

        }
    }


}
