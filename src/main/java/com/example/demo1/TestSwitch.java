package com.example.demo1;

public class TestSwitch {
    public static void main(String[] args) {
        String test = "test";

        switch (test){
            case "ceshi":
            case "":{
                System.out.println("chinese");
                break;
            }
            case "test":{
                System.out.println("english");
                break;
            }
            default:{
                System.out.println("nothing");
                break;
            }
        }
    }
}
