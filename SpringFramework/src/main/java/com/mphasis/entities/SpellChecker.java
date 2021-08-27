package com.mphasis.entities;

public class SpellChecker {
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public SpellChecker(){
        System.out.println("inside SpellChecker constructor");
    }

    public void checkSpelling(){
        System.out.println("inside checkSpelling method");
    }
}
