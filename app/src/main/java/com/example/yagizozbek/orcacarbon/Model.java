package com.example.yagizozbek.orcacarbon;

public class Model{
    String name;
    int value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */

    Model(String name){
        this.name = name;
        this.value = 0;
    }
    public String getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }

}
