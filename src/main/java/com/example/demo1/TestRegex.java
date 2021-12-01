package com.example.demo1;

public class TestRegex {
    public static void main(String[] args) {
        String regexForRgName = "^((\\w)|(-)|([\\u4e00-\\u9fa5])){1,20}?$";
        System.out.println("组-A".matches(regexForRgName));
    }
}
