package com.example.demo1.aop;

import com.example.demo1.annotation.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author a58
 * http://localhost:8080/aop/test1?id=1
 */

@Api
@Controller
@RequestMapping("/aop")
public class AspectController {

    @ApiOperation(value = "你好")
    @ResponseBody
    @RequestMapping("/test1")
    @Auth(pid = "123456")
    public void test1(@RequestParam Integer id) {
        System.out.println("this is a test!!");
        try {
            int temp = 2 / id;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
