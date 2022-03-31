package com.example.demo1;

import com.example.demo1.testPackage.TestDefault;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        String[] split = "58集团\\技术工程平台群\\架构线|58集团\\技术工程平台群\\基础体验产品部|58集团\\技术工程平台群\\研发管理部".split("\\|");
        for(String str : split){
            System.out.println(str);
        }
    }

    @Test
    public void test2(){
        TestDefault testDefault = new TestDefault();
        
        testDefault.setSubmitUserName("sea");
        System.out.println(testDefault.getSubmitUserName());
    }
}
