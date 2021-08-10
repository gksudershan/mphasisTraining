package com.mphasis.main.cui;

import javax.swing.*;
import static com.mphasis.main.cui.Month.*;
class Outer{
    static class Inner{
        int value = 10;
    }
}

class Test{
    static int value;

    static{
        value = 55;
        System.out.println("Static initializer");
    }

    Test(){
        value = 10;
    }

    {
        System.out.println("Inline");
    }
}

enum Month{
    JAN(31),FEB(28),MAR(30);

    int days;

    Month(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
public class Main {

    public static void main(String[] args) {

        Outer.Inner outerInner = new Outer.Inner();
        System.out.println(outerInner.value);
        Test.value = 45;

        System.out.println(Test.value);

        Month mMonth = Month.FEB;

        if (mMonth.valueOf("FEB")==Month.FEB){
            System.out.println("February");
        }

        for(Month month:Month.values())
        {
            System.out.println(month+" has " + month.days + " days ");
        }

        JOptionPane.showMessageDialog(null,"Good Afternoon","Greetings",JOptionPane.WARNING_MESSAGE);
    }
}
