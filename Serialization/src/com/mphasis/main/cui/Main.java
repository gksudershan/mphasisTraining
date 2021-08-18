package com.mphasis.main.cui;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID=1l;
    int id,age;
    String name;
    int test;
    transient int value;

    public Person(int id, String name,int age,int value) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", test=" + test +
                ", value=" + value +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Serialization
        Person person = new Person(1,"Allen",21,10);
        try(FileOutputStream fileOutputStream  = new FileOutputStream("ObjectStore.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            FileInputStream fileInputStream = new FileInputStream("ObjectStore.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            //Serialization
            objectOutputStream.writeObject(person);
            //Deserialization
            Object object = objectInputStream.readObject();
            System.out.println(object);
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
