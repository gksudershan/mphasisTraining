package com.mphasis.main.cui;

import com.mphasis.pack1.Base1;
import com.mphasis.pack1.Base2;
import com.mphasis.pack2.Derived;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Derived derived = new Derived();
        derived.test();
        Base1 base1 = new Base1();
        base1.publicField =3;

    }
}
