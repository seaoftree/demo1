package com.example.demo1.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/aop")
public class AspectController {
    @ResponseBody
    @RequestMapping("/test1")
    public void test1(@RequestParam Integer id){
        System.out.println("this is a test!!");
        try {
            int temp = 2 / id;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw  e ;
        }
    }
}
