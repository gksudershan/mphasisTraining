package com.mphasis.livingbeings.mammals;

import com.mphasis.livingbeings.mammals.organs.Eye;


public class Human {
    public HumanEye leftEye,rightEye;

    public Human(){
        leftEye = new HumanEye();
        rightEye = new HumanEye();
    }

    public class HumanEye extends Eye{

    }
}
