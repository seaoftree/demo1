package com.example.demo1;

import java.util.List;

public class TestRegex {
    public static void main(String[] args) {
//        String regexForSysCode = "^[a-zA-Z]{3,10}?$";
//        System.out.println("aa".matches(regexForSysCode));
        StringBuffer stringBuffer = new StringBuffer("11,22,22,33,");

        String managerIds = stringBuffer.substring(0, stringBuffer.length() - 1);
        System.out.println(managerIds);
    }
}
