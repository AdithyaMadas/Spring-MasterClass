package com.madas;

public interface NumberGenerator {

    //Generates a random number less than the set maxNumber number
    int next();

    //Returns the set Max Number
    int getMaxNumber();

    int getMinNumber();

}
