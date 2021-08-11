package com.mphasis.pack2;

import com.mphasis.pack1.Base1;

public class Derived extends Base1 {
    public void test(){
        publicField = 4;
        protectedField = 4;
    }

    public Derived(){
        this.protectedField = 1;
        this.base1.publicField = 4;
    }
    Base1 base1 = new Base1();



}
