package com.mphasis.main.cui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Stream<String> nameStream = Stream.of("mohan","john","vaibhav","amit");
        Stream<String> nameStartJ = nameStream.map(String::toUpperCase)
                .peek(e-> System.out.println(e))
                .filter(s->s.startsWith("J"));

        System.out.println("Calling terminal operation: count");
        long count = nameStartJ.count();
        System.out.println("Count: " + count);
        System.out.println();

        List<Employee> employeeList = getListOfEmployees();
        List<String> res;
        List<Employee> ans;

        res = employeeList.stream()
                .map(e->e.getName())
                .collect(Collectors.toList());
        System.out.println(res);

        res = employeeList.stream()
                .map(e->e.getName())
                .filter(s->s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(res);

        ans = employeeList.stream()
                .sorted(Employee::compareTo)
                .collect(Collectors.toList());
        System.out.println(ans);

        ans = employeeList.stream()
                .collect(Collectors.toList());

        System.out.println(ans);
    }

    public static List<Employee> getListOfEmployees(){

        List<Employee> employeeList = new ArrayList<Employee>();

        Employee e1 = new Employee("Mohan",24, Arrays.asList("Newyork","Bangalore"));
        Employee e2 = new Employee("John",27, Arrays.asList("Paris","London"));
        Employee e3 = new Employee("Vaibhav",32, Arrays.asList("Pune","Seattle"));
        Employee e4 = new Employee("Amit",22, Arrays.asList("Chennai","Hyderabad"));

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        return employeeList;
    }
}
