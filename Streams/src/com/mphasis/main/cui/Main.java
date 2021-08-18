package com.mphasis.main.cui;

import com.mphasis.entities.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int result=0;
        for(int value:numbers){
            if(value%2==0){
                result+=value*2;
            }
        }

        System.out.println(result);

        int res = numbers.stream()
                .filter((value)-> value%2==0)
                .mapToInt(value->value*2)
                .sum();

        numbers.stream()
                .map((element)->String.valueOf(element))
                .forEach((element)-> System.out.println(element));
        int reducedResult = numbers.stream()
                .filter(value->value%2==0)
                .reduce(1,(ans,i)->ans*i);
        System.out.println(reducedResult);

        String concatResult = numbers.stream()
                .map(String::valueOf)
                .reduce("",(concatStr,str)->concatStr.concat(str));

        System.out.println(concatResult);

        List<Integer> doubleOfEven;
        // = new ArrayList<Integer>();
        doubleOfEven = numbers.stream()
                .filter(element->element%2==0)
                .map(element->element*2)
                .collect(Collectors.toList());

        System.out.println(doubleOfEven);
        List<Person> personList =  createPeople();

        Map<Integer,Person> personMap = personList.stream()
                .filter(person->person.getAge()<30)
                .collect(Collectors.toMap(Person::getId,person->person));

        Map<Integer,List<Person>> personListMap = personList.stream()
                .collect(Collectors.groupingBy(person->person.getAge()));

        Map<Integer,List<String>> names = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toList())));
        System.out.println(personMap);
        System.out.println(personListMap);
        System.out.println(names);

    }
    public static List<Person> createPeople(){
        return Arrays.asList(
                new Person(1,"Allen",34),
                new Person(2,"Susan",26),
                new Person(3,"David",36),
                new Person(4,"Rahul",14),
                new Person(5,"Bill",45),
                new Person(6,"Adam",31)
        );
    }
}
